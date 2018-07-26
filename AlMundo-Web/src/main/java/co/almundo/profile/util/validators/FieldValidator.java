/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.util.validators;

import co.almundo.profile.api.util.EnumErrorConfig;
import co.almundo.profile.util.AlmundoBaseBean;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validator del login de usaurio.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@FacesValidator("FieldValidator")
public class FieldValidator extends AlmundoBaseBean implements Validator
{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException
    {
        String field = o.toString();
        UIInput uiInputConfirmPassword = (UIInput) uiComponent.getAttributes().get("password");
        String password = uiInputConfirmPassword.getSubmittedValue().toString();
        if ((field == null || field.equals("")) || (password == null || password.equals("")))
        {
            String message = AlmundoBaseBean.findMessage(EnumErrorConfig.PROFILER_GENERIC_ERROR_FIELD_REQUIRED.getRefbundle());
            addErrorMessageValidator(message);
        }
    }
}
