/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.api.services;

import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.SalaLlamadas;
import co.almundo.profile.api.models.Usuarios;

/**
 * Interfaz de servicio para el manejo de la informacion
 * de las llamadas entrantes a las salas de espera.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public interface SalasLlamadasServices
{
    /**
     * Asigna la llamada a un asesor disponible
     * o la deja encolada
     * @throws ServiceException
     */
     public SalaLlamadas asignarNuevaLlamada()throws ServiceException;

    /**
     * Publicar conexion
     * @throws ServiceException
     */
    public void conectarSala(Usuarios usuario)throws ServiceException;

}
