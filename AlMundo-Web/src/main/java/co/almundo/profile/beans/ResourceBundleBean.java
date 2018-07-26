/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import java.util.HashMap;

/**
 * Clase encargada de cargar los mensajes de aplicacion
 * y proveerlo a quien consuma.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Component(value = "msg")
public class ResourceBundleBean extends HashMap
{
    /**
     * Recurso de mensajes de spring
     */
    @Autowired
    private MessageSource messageSource;

    @Override
    public String get(Object key)
    {
        ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String message;
        try
        {
            message = messageSource.getMessage((String) key, null, request.getLocale());
        }
        catch (NoSuchMessageException e)
        {
            message = "???" + key + "???";
        }
        return message;
    }
}