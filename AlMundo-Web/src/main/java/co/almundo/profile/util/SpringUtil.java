/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.util;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * Utilidad de Spring.
 * @author Yaher Carrillo
 * @date 25/07/201
 */
public abstract class SpringUtil
{
    /** Contexto de la aplicacion */
    private static ServletContext servletContext;
    
    /**
     * Constructor para evitar crear el objeto.
     */
    private SpringUtil()
    {
    }
    
    /**
     * Regresa un objeto creado por spring por medio del ServletContext. Se debe haver definido previamente el contexto mediante la funcion setServletContext.
     * @param name Nombre del bean
     * @return Objeto creado por spring.
     */
    @SuppressWarnings("unchecked")
    public static <CLASS> CLASS getSpringBean(String name)
    {
        WebApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return (CLASS) appContext.getBean(name);
    }
    
    /**
     * Cambia le valor de la propiedad servletContext
     * @param servletContext Valor nuevo de la propiedad servletContext.
     */
    public static void setServletContext(ServletContext servletContext)
    {
        SpringUtil.servletContext = servletContext;
    }
    
    /**
     * Obtiene el servletContext
     * @return el servletContext
     */
    public static ServletContext getServletContext()
    {
        return servletContext;
    }
}
