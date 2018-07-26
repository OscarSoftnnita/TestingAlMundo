/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.util.validators;

import co.almundo.logger.util.Log;
import co.almundo.logger.util.ModulesAlMundo;
import co.almundo.profile.api.services.UsuariosService;
import co.almundo.profile.api.util.EnumErrorConfig;
import co.almundo.profile.api.util.EnumServicesAlmundoConfig;
import co.almundo.profile.util.AlmundoBaseBean;
import co.almundo.profile.util.SpringUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validator de la clave actual de sistema.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@FacesValidator("CurrentPassValidator")
public class CurrentPassValidator extends AlmundoBaseBean implements Validator
{
    /**
     * Servicio de Consulta de usuarios.
     */
    private UsuariosService userServices;
    /**
     * Servicio de autenticacion
     */
    private AuthenticationManager authenticationManager;

    /**
     * Contructor por defecto
     */
    public CurrentPassValidator()
    {
        init();
    }

    /**
     * Se inicializan los valores y servicios a usar en el validator.
     */
    public void init()
    {
        userServices = SpringUtil.getSpringBean(EnumServicesAlmundoConfig.SERVICES_USERS_PROXY.getNameService());
        authenticationManager = SpringUtil.getSpringBean(EnumServicesAlmundoConfig.SERVICES_AUTH_SPRING.getNameService());
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException
    {
        String loginUsuario = o.toString();
        UIInput uiInputConfirmPassword = (UIInput) uiComponent.getAttributes().get("loginconnect");
        String claveActual = uiInputConfirmPassword.getSubmittedValue().toString();
        try
        {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario, claveActual));
        }
        catch (AuthenticationException e)
        {
            String message = AlmundoBaseBean.findMessageError(EnumErrorConfig.PROFILER_USER_CURRENT_PASS.getCode());
            addErrorMessageValidator(message);
            Log.getInstance().warn(ModulesAlMundo.ALMUNDO_PROFILE.getCodigo(), "", "Error VALIDATOR validando la clave actual de usuario", e);
        }
    }
}
