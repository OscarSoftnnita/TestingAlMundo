/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.dao.impl;

import co.almundo.profile.api.dao.UsuarioPerfilDao;
import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.models.Perfiles;
import co.almundo.profile.api.models.UsuarioPerfil;
import co.almundo.profile.api.models.Usuarios;
import co.almundo.profile.impl.dao.HibernateDaoImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase abstracta para la manipulacion de operaciones crud de la entidad
 * Usuario Perfiles.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Repository("usuarioPerfilDao")
public class UsuarioPerfilDaoImpl extends HibernateDaoImpl<Integer, UsuarioPerfil> implements UsuarioPerfilDao
{

    @Override
    public List<Perfiles> buscarPerfilesUsuarios(Usuarios usuario) throws DaoException
    {
        Session session = this.getSession();
        Query query = session.getNamedQuery("buscarPerfilesUsuarios");
        query.setParameter("PARAM_USER", usuario.getId());
        List<Perfiles> usuarioPerfiles = (List<Perfiles>)query.list();
        return usuarioPerfiles;// OK
    }
}
