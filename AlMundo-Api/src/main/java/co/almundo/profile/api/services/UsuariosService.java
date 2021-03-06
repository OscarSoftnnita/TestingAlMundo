/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */

package co.almundo.profile.api.services;

import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.modelsweb.DatosSesionUsuario;
import co.almundo.profile.api.models.Usuarios;

import java.util.List;

/**
 * Interfaz que expone los servicios del modelo de negocio
 * referentes al tratado de usuarios.
 * @author Yaher Carrillo
 * @Date 24/07/2018
 */
public interface UsuariosService
{
    /**
     * Se valida un usuario segun su login de acceso
     * @param login login a validar
     * @param clave clave a validar
     * @return Objeto con el los datos de usuario
     * @throws ServiceException sucede si falla la operacion
     */
    public DatosSesionUsuario validateUser(String login,String clave) throws ServiceException;

    /**
     * Regersa la informacion de usuario
     * @param login nombre de login de usuario
     * @return Objeto usuarios
     * @throws ServiceException Sucede si falla la operacion.
     */
    public Usuarios validateUser(String login) throws ServiceException;

    /**
     * Obtiene todos los usuarios del sistema
     * @param estado estado que se desea buscar
     * @return Listado de usuarios
     * @throws ServiceException Excepcion que ocurre si falla la operacion
     */
    public List<Usuarios> getAll(boolean estado) throws ServiceException;

    /**
     * Valida la clave actual del usuario
     * @param usuario usuario a validar
     * @param claveActual clave actual a validar
     * @return logico que indica si la clave es valida
     * @throws ServiceException Excepcion que ocurre si falla la operacion.
     */
    public boolean validateCurrentPassUser(Usuarios usuario,String claveActual) throws ServiceException;

    /**
     * Cambia la clave actual del usuario
     * @param usuario usuario a cambiar la clave
     * @param nuevaClave clave nueva
     * @throws ServiceException Excepcion que ocurre si falla la operacion.
     */
    public void changePassUser(Usuarios usuario,String nuevaClave) throws ServiceException;

}
