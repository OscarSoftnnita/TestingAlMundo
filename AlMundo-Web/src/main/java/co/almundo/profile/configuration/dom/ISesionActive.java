/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.configuration.dom;

import co.almundo.profile.api.modelsweb.DatosSesionUsuario;

public interface ISesionActive
{
    /**
     * Retorna los datos de sesion activa del ambito
     * nuevo.
     * @return datos de sesion de usuario
     */
    public abstract DatosSesionUsuario getDatosSesion();

    /**
     * Asigana los valores de usuario en la sesion-
     * @param datosSesion datosSesion.
     */
    public abstract void setDatosSesion(DatosSesionUsuario datosSesion);

}
