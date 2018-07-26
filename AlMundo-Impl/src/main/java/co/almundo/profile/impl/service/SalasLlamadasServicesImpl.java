/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.service;

import co.almundo.profile.api.dao.SalaEsperaLlamadasDao;
import co.almundo.profile.api.dao.SalaLlamadasDao;
import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.SalaEsperaLlamadas;
import co.almundo.profile.api.models.SalaLlamadas;
import co.almundo.profile.api.models.Usuarios;
import co.almundo.profile.api.services.SalasLlamadasServices;
import co.almundo.profile.api.util.EnumErrorConfig;
import co.almundo.profile.api.util.EnumEstatusLlamadas;
import co.almundo.profile.api.util.EnumEstatusSalasEsperaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("salasLlamadasServicesImpl")
@Transactional
public class SalasLlamadasServicesImpl implements SalasLlamadasServices
{
    /**
     * Dao que revisa las llamadas en sala.
     */
    @Autowired
    private SalaLlamadasDao salaLlamadasDao;

    /**
     * Dao que revisa la sala de espera.
     */
    @Autowired
    private SalaEsperaLlamadasDao salaEsperaLlamadasDao;

    @Override
    public synchronized SalaLlamadas asignarNuevaLlamada() throws ServiceException
    {
        SalaLlamadas nuevaAtencion;
        try
        {
            List<SalaEsperaLlamadas> salasEspera = salaEsperaLlamadasDao.buscarAsesorDisponble();
            if (salasEspera != null || !salasEspera.isEmpty())
            {
                /*Se crea la atencion*/
                nuevaAtencion = new SalaLlamadas();
                nuevaAtencion.setUsuario(salasEspera.get(0).getUsuario());
                nuevaAtencion.setEstatus_sala(EnumEstatusLlamadas.LLAMADA_ATENDIENDOSE.getStatus());
                nuevaAtencion.setHora_inicio(new Date());
                nuevaAtencion.setHora_fin(new Date());
                nuevaAtencion.setNombre_sala(UUID.randomUUID().toString());
                salaLlamadasDao.agregar(nuevaAtencion);

                /*Se indica a la sala de espera que el usaurio se acaba de ocupar*/

                SalaEsperaLlamadas salaAct = salaEsperaLlamadasDao.buscarPorId(salasEspera.get(0).getId());
                salaAct.setEstatus_usuario(EnumEstatusSalasEsperaConfig.USER_NOT_AVAILABLE.getCode());
                salaEsperaLlamadasDao.actualizar(salaAct);

            }
            else
                throw new DaoException(EnumErrorConfig.PROFILER_USER_WITHOUT_PROFILES.getCode());
        }
        catch (DaoException e)
        {
            String mensaje = "Error al asignar la llamada";
            throw new ServiceException(mensaje, e, e.getCode());
        }
        return nuevaAtencion;
    }

    @Override
    public void conectarSala(Usuarios usuario) throws ServiceException
    {
        try
        {
            /*se busca si el usuario estuvo previamente conectado y se actualiza el registro*/
            SalaEsperaLlamadas salaEspera = new SalaEsperaLlamadas();
            salaEspera.setUsuario(usuario);
            salaEspera = salaEsperaLlamadasDao.buscarObjetoUnico(salaEspera);
            if (salaEspera == null)
            {
                /*Se registra la sala de espera del usuario*/
                salaEspera = new SalaEsperaLlamadas();
                salaEspera.setUltima_hora_conec(new Date());
                salaEspera.setEstatus_usuario(EnumEstatusSalasEsperaConfig.USER_AVAILABLE.getCode());
                salaEspera.setUsuario(usuario);
                salaEsperaLlamadasDao.agregar(salaEspera);
            }
            else
            {
                salaEspera.setEstatus_usuario(EnumEstatusSalasEsperaConfig.USER_AVAILABLE.getCode());
                salaEspera.setUltima_hora_conec(new Date());
                salaEsperaLlamadasDao.actualizar(salaEspera);
            }
        }
        catch (DaoException e)
        {
            String mensaje = "Error al conectar a la sala";
            throw new ServiceException(mensaje, e, e.getCode());
        }
    }
}
