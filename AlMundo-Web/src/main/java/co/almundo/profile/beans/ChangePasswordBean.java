/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.beans;

import co.almundo.logger.util.Log;
import co.almundo.logger.util.ModulesAlMundo;
import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.services.UsuariosService;
import co.almundo.profile.configuration.dom.ISesionActive;
import co.almundo.profile.configuration.navigation.EnumNavigationConfig;
import co.almundo.profile.util.AlmundoBaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Bean FRONT-END para el manejo y administracion
 * de claves de usuario.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Component
@ManagedBean(name = "changePasswordBean")
@RequestScoped
public class ChangePasswordBean extends AlmundoBaseBean implements Serializable
{
    /**
     * Clave actual de sistema del usuario autenticado
     */
    private String passAct;
    /**
     * Nueva clave del usuario autenticado en sistema
     */
    private String passNew;
    /**
     * Confirmacion de clavbe de usuario
     */
    private String confirmPass;
    /**
     * Servicio de informacion de sesion del usuario
     */
    @Autowired
    private ISesionActive iSesionActive;
    /**
     * Servicios de usuario de sistema
     */
    @Autowired
    @Qualifier("proxyUsuariosService")
    private UsuariosService userServices;
    /**
     * Servicio de manejo de claves
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Metodo de procesamiento
     * que cambia la clave actual del usuario autenticado en el sistema.
     * @return
     */
    public String changePassSesionUserProcess(){
        String username = iSesionActive.getDatosSesion().getUsuario().getLogin();
        try{
            passNew = passwordEncoder.encode(passNew);
            userServices.changePassUser(iSesionActive.getDatosSesion().getUsuario(),passNew);
            String message = AlmundoBaseBean.findMessage("login.success.001");
            addSuccessMessage(message);

        }catch (ServiceException ex){
            String code_error = ex.getCode();
            String message = AlmundoBaseBean.findMessageError(code_error);
            addErrorMessage(message);
            Log.getInstance().warn(ModulesAlMundo.ALMUNDO_PROFILE.getCodigo(), username, "Error cambiando la clave de usuario", ex);
        }
        return EnumNavigationConfig.DONT_ACCESS.getName();
    }

    /**
     * Obtiene la clave actual del usuario
     * autenticado.
     *
     * @return clave actual
     */
    public String getPassAct()
    {
        return passAct;
    }

    /**
     * Asigna un valor a la clave actual del usuario
     * autenticado
     *
     * @param passAct valor a asignar
     */
    public void setPassAct(String passAct)
    {
        this.passAct = passAct;
    }

    /**
     * Obtiene la nueva clave a cambiar
     * del usuario autenticado del sistema
     *
     * @return nueva clave
     */
    public String getPassNew()
    {
        return passNew;
    }

    /**
     * Asigna un valor a la nueva clave
     * del usuario autenticado del sistema
     *
     * @param passNew valor a asignar
     */
    public void setPassNew(String passNew)
    {
        this.passNew = passNew;
    }

    /**
     * Obtiene el valor de la confirmacion de
     * la clave del usuario autenticado
     *
     * @return confirmacion de clave
     */
    public String getConfirmPass()
    {
        return confirmPass;
    }

    /**
     * Asigna un valor de confirmacion de clave
     * del usuario de sistema
     *
     * @param confirmPass valor de clave
     */
    public void setConfirmPass(String confirmPass)
    {
        this.confirmPass = confirmPass;
    }
}
