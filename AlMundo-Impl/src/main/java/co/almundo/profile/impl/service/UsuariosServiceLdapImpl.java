/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.service;

import co.almundo.profile.api.dao.UsuariosDao;
import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.Usuarios;
import co.almundo.profile.api.modelsweb.DatosSesionUsuario;
import co.almundo.profile.api.services.UsuariosService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementacion de servicios de consulta de usuarios a traves de LDAP
 * @author Yaher Carrillo
 * @Date 24/07/2018
 */
@Service("usuariosServiceLdapImpl")
@Transactional
public class UsuariosServiceLdapImpl implements UsuariosService
{

    /**
     * Objeto utilizado para el log
     */
    private static final Log logger = LogFactory.getLog(UsuariosServiceLdapImpl.class);
    /**
     * Dao de servicios crud de usuarios
     */
    @Autowired
    private UsuariosDao usuariosDao;

    @Override
    public DatosSesionUsuario validateUser(String loginUsuario,String clave) throws ServiceException
    {
        try
        {
            usuariosDao.getUsuarioPorLogin(loginUsuario);
            return null;
        }
        catch (DaoException e)
        {
            String mensaje = "Error al validar los usuarios el usuarios [" + loginUsuario + "]";
            logger.error(mensaje, e);
            throw new ServiceException(mensaje, e);
        }
    }

    @Override
    public Usuarios validateUser(String loginUsuario) throws ServiceException
    {
        try
        {
            return  usuariosDao.getUsuarioPorLogin(loginUsuario);

        }
        catch (DaoException e)
        {
            String mensaje = "Error al validar los usuarios el usuarios [" + loginUsuario + "]";
            logger.error(mensaje, e);
            throw new ServiceException(mensaje, e);
        }
    }

    @Override
    public List<Usuarios> getAll(boolean estado) throws ServiceException
    {
        try
        {
            return usuariosDao.getUsuarioPorEstados(estado);
        }
        catch (DaoException e)
        {
            String mensaje = "Error al obtener el listado de Usuarios por estado [" + estado + "]";
            logger.error(mensaje, e);
            throw new ServiceException(mensaje, e);
        }
    }

    @Override
    public boolean validateCurrentPassUser(Usuarios usuario, String claveActual) throws ServiceException
    {
        return false;
    }

    @Override
    public void changePassUser(Usuarios usuario, String nuevaClave) throws ServiceException
    {

    }
}
