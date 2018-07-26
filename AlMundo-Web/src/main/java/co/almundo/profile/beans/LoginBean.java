/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.beans;

import co.almundo.logger.util.Log;
import co.almundo.logger.util.ModulesAlMundo;
import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.Usuarios;
import co.almundo.profile.api.modelsweb.DatosSesionUsuario;
import co.almundo.profile.api.services.SalasLlamadasServices;
import co.almundo.profile.api.services.UsuariosService;
import co.almundo.profile.api.util.EnumErrorConfig;
import co.almundo.profile.configuration.dom.ISesionActive;
import co.almundo.profile.configuration.navigation.EnumNavigationConfig;
import co.almundo.profile.util.AlmundoBaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Map;

/**
 * Bean FRONT-END para el manejo de la informacion
 * en el login de sistema.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Component
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean extends AlmundoBaseBean implements Serializable
{
    /**
     * Nombre de acceso de un determinado usuario
     */
    private String username;
    /**
     * Clave de acceso de usuario
     */
    private String password;
    /**
     * Servicio de Consulta de usuarios.
     */
    @Autowired
    @Qualifier("proxyUsuariosService")
    private UsuariosService userServices;
    /**
     * Servicio de recursos en mensajes.
     */
    @Autowired
    private MessageSource messageSource;
    /**
     * Servicio de datos de sesion de usuario
     */
    @Autowired
    private ISesionActive iSesionActive;

    /**
     * Servicio de operaciones de llamadas
     */
    @Autowired
    private SalasLlamadasServices servicioLlamadas;

    /**
     * Evento iniacl invocado por la vista profileUser.xhtml para iniciar el bean
     *
     * @param event Evento
     */
    public void preRenderViewLogin(ComponentSystemEvent event)
    {
        loadSession();
    }

    /**
     * Evento iniacl invocado por la vista profileUser.xhtml para iniciar el bean
     *
     * @param event Evento
     */
    public void preRenderViewIndex(ComponentSystemEvent event)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String errorAuth = paramMap.get("error");
        if (errorAuth != null)
        {
            String message = AlmundoBaseBean.findMessage(EnumErrorConfig.PROFILER_USER_OR_PASS_DOES_NOT_EXIST.getRefbundle());
            addErrorMessage(message);
        }
    }

    /**
     * Carga la sesion del ususario
     * en el bean de sesion para ser usado
     * a demanda.
     */
    public void loadSession()
    {
        username = this.loginUserContext();
    }

    /**
     * Metodo de procesamiento de la informacion del bean
     * que consulta la informacion de usuarios y permite su acceso
     * o no a las bondades del sistema
     *
     * @return recurso de navegacion a donde redireccionara la pagina.
     */
    public synchronized String process()
    {
        Usuarios usuario;
        try
        {
            HttpSession session = AlmundoBaseBean.getHttpSession();
            usuario = userServices.validateUser(username);
            if (usuario != null)
            {
                DatosSesionUsuario datosSesionUsuario = new DatosSesionUsuario();
                datosSesionUsuario.setUsuario(usuario);
                datosSesionUsuario.setIdSesionWeb(session.getId());
                iSesionActive.setDatosSesion(datosSesionUsuario);
                session.setAttribute(CONSTANT_USER_SESION, iSesionActive);
                UsuarioEscuchandoLlamadas(usuario);
                return EnumNavigationConfig.WELCOME_PAGE.getName();
            }

        }
        catch (ServiceException e)
        {
            String code_error = e.getCode();
            String message = AlmundoBaseBean.findMessageError(code_error);
            addErrorMessage(message);
            Log.getInstance().warn(ModulesAlMundo.ALMUNDO_PROFILE.getCodigo(), username, "Error consultando usuario", e);
        }
        catch (Exception e)
        {
            Log.getInstance().error(ModulesAlMundo.ALMUNDO_PROFILE.getCodigo(), AlmundoBaseBean.USER_GUEST_LOG, "Error GENERICO consultando usuario", e);
        }
        return EnumNavigationConfig.DONT_ACCESS.getName();
    }

    /**
     * Asigna el estatus de llamadas a recibir
     * para el usuario.
     */
    public void UsuarioEscuchandoLlamadas(Usuarios usuario){
        /*Se asigna la conexion a la sala de espera*/
        /**
         * FixMe en este punto segun politicas
         * de la compañia se pueden colocar los estatus que dependan
         * del rol de usuario para laborar en el call center
         */
        try
        {
            servicioLlamadas.conectarSala(usuario);
        }
        catch (ServiceException e)
        {
            Log.getInstance().warn(ModulesAlMundo.ALMUNDO_PROFILE.getCodigo(), username, "Error consultando usuario", e);
        }
    }

    /**
     * Metodo que extrae la informacion de usuario autenticado del contexto
     *
     * @return login name
     */
    public String loginUserContext()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User ctxUser = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        return ctxUser.getUsername();
    }

    /**
     * Obtiene el recurso de nombre de usuario del bean de manejo
     *
     * @return Cadena con el nombre de usuario.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Asigna un valor al nombre de usuario en el bean
     * de manejo.
     *
     * @param username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Obtiene la clave de acceso del usuario
     *
     * @return clave de acceso
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Asigna un valor a la clave de acceso
     *
     * @param password valor a asignar
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
}
