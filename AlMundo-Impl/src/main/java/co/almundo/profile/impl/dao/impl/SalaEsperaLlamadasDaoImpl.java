
/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.dao.impl;

import co.almundo.profile.api.dao.SalaEsperaLlamadasDao;
import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.models.SalaEsperaLlamadas;
import co.almundo.profile.api.models.Usuarios;
import co.almundo.profile.api.util.EnumEstatusSalasEsperaConfig;
import co.almundo.profile.impl.dao.HibernateDaoImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase abstracta para la manipulacion de operaciones crud de la entidad
 * SalaEsperaLlamadas.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Repository("salaEsperaLlamadasDao")
public class SalaEsperaLlamadasDaoImpl extends HibernateDaoImpl<Integer,SalaEsperaLlamadas> implements SalaEsperaLlamadasDao
{
    @Override
    public List<SalaEsperaLlamadas> buscarAsesorDisponble() throws DaoException
    {
        Session session = this.getSession();
        Query query = session.getNamedQuery("buscarAsesoresPorEstado");
        query.setParameter("PARAM_STATUS", EnumEstatusSalasEsperaConfig.USER_AVAILABLE.getCode());
        List<SalaEsperaLlamadas> usuarios = (List<SalaEsperaLlamadas>) query.list();
        return usuarios;// OK
    }
}
