/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */

package co.almundo.profile.api.services;

import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.Usuarios;

/**
 * Interfaz de servicio para el manejo de la informacion
 * de sesion de usuarios conectados. Solo se emitiran procesos de
 * consulta.
 * @author Yaher Carrill
 * @Date 24/07/2018
 */
public interface SesionActivaService
{
    /**
     * Obtiene los datos basicos de sesion del usuario.
     *
     * @return Objeto de usuarios
     * @throws ServiceException Excepcion que ocurre si falla la operacion.
     */
    public Usuarios getUsuarioSesion() throws ServiceException;
}
