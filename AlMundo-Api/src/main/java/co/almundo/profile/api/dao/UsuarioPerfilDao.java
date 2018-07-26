/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */

package co.almundo.profile.api.dao;

import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.models.Perfiles;
import co.almundo.profile.api.models.UsuarioPerfil;
import co.almundo.profile.api.models.Usuarios;

import java.util.List;

/**
 * Interfaz de acceso a servicios CRUD  de la entidad
 * Usuario_Perfil.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public interface UsuarioPerfilDao extends HibernateDao<UsuarioPerfil, Long>
{
    /**
     * Busca los perfiles de un usuario.
     * @return listado de ID'S de perfiles de usuario
     * @throws DaoException Excepcion que ocurre si falla la operacion
     */
    public List<Perfiles> buscarPerfilesUsuarios(Usuarios usuario) throws DaoException;
}
