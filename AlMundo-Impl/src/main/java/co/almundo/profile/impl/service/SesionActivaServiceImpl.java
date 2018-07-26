/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.service;

import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.Usuarios;
import co.almundo.profile.api.services.SesionActivaService;
/**
 * Implementacion de conusmo de los datos
 * de sesion del usuario conectado.
 * @author Yaher Carrillo
 * @Date 24/07/2018
 */
public class SesionActivaServiceImpl implements SesionActivaService
{
    public Usuarios getUsuarioSesion() throws ServiceException
    {
        Usuarios usuario = null;
        return usuario;
    }
}
