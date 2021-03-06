
/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.api.util;

/**
 * Enum que describe los errores manejados por la aplicacion
 * cada item puede ser usado por el core de negocio
 * o por las entidades que expongas puertas de acceso a la informacion
 * pueden basarse en este para su manejo y exposicion de fallas.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public enum EnumErrorConfig
{
    PROFILER_USER_DOES_NOT_EXIST("001", "El usuario no existe", "login.error.001"),
    PROFILER_USER_WRONG_KEY("002", "Clave Errada de usuario.", "login.error.002"),
    PROFILER_USER_WITHOUT_PROFILES("003", "Usuario sin perfiles.","login.error.003"),
    PROFILER_USER_CURRENT_PASS("004", "Clave Actual Errada.","login.error.004"),
    PROFILER_USER_CONFIRM_PASS("005", "La Nueva clave no coincide con la confirmacion.","login.error.005"),
    PROFILER_USER_OR_PASS_DOES_NOT_EXIST("006", "El usuario no existe", "login.error.006"),
    PROFILER_USERS_NOT_AVAILABLE("007", "Usuarios no dispobible para llamadas", "login.error.007"),
    PROFILER_GENERIC_ERROR_FIELD_REQUIRED("091", "Error generico, campo requerido", "login.error.091"),
    PROFILER_GENERIC_ERROR("099", "Error generico, modulo Profiler", "login.error.099");
    /**
     * Codigo de la navegacion
     **/
    private String code;
    /**
     * Descripcion del error
     */
    private String description;
    /**
     * Referencia de objetos de mensajes globales
     */
    private String refbundle;

    /**
     * Constructor del Enum que inicializa valores
     *
     * @param code        identificador del elemento
     * @param description ruta del recurso
     * @param refbundle   referencia del archivo de recursos
     */
    EnumErrorConfig(String code, String description, String refbundle)
    {
        this.code = code;
        this.description = description;
        this.refbundle = refbundle;
    }

    /**
     * Obtiene el codigo de busqueda del elemento
     *
     * @return codigo de error
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Asigna el codigo a un elemento de error.
     *
     * @param code valor a asignar
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * Obtiene la desdcripcion del error
     *
     * @return
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Asigna una valor a la descripcion del error
     *
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Obtiene la llave de referencia del archivo de recursos de texto
     *
     * @return
     */
    public String getRefbundle()
    {
        return refbundle;
    }

    /**
     * ASsigna un valor de la referencia de resursos de texto
     *
     * @param refbundle
     */
    public void setRefbundle(String refbundle)
    {
        this.refbundle = refbundle;
    }
}
