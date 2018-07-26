
/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.api.util;

/**
 * Enum que describe los estatus que manejan
 * las salas de espera.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public enum EnumEstatusSalasEsperaConfig
{
    USER_AVAILABLE("001", "Usuario Disponible", "status.sala.available"), USER_NOT_AVAILABLE("002", "Usuario No disponible", "status.sala.noavailable"), USER_DISCONTINUED("003", "Usuario suspendido", "status.sala.discontinued");

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
    EnumEstatusSalasEsperaConfig(String code, String description, String refbundle)
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
