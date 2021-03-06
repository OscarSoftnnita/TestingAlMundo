/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.api.dao;

import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.models.Usuarios;

import java.util.Date;
import java.util.List;

/**
 * Interfaz de acceso a servicios CRUD  de la entidad
 * Usuarios.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public interface UsuariosDao extends HibernateDao<Usuarios, Long>
{
    /**
     * Busca un usuario por su login
     * @param login nombre de login de usuario
     * @return objeto usuario
     * @throws DaoException excepcion que ocurre durante la consulta
     */
    public Usuarios getUsuarioPorLogin(String login)throws DaoException;

    /**
     * Busca un usuario activo durante las fechas establecidas
     * @param login nombre de usuario
     * @return Objeto usuario
     * @throws DaoException Excepcion que ocurre si falla la consulta
     */
    public List<Usuarios> getUsuarioActivosMes(String login) throws DaoException;

    /**
     * Busca un usuario activo en la aplicacion entre las
     * ultimas 2 fechas
     * @param fecha_inicio fecha de inicio de busqueda
     * @param fecha_fin fecha fin de busqueda
     * @return Listado de usuarios
     * @throws DaoException Excepcion que ocurre si falla la consulta
     */
    public List<Usuarios> getUsuarioActivosEntreFechas(Date fecha_inicio, Date fecha_fin) throws DaoException;

    /**
     * Obtiene todos los usuarios del sistema segun su estado
     * @param activo estado que indica la disponibilidad del usuario
     * @return Listado de usuarios
     * @throws DaoException Excepcion que ocurre si falla la consulta
     */
    public List<Usuarios> getUsuarioPorEstados(boolean activo) throws DaoException;
}
