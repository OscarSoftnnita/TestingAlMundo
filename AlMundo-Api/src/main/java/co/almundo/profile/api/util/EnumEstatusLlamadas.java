/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */

package co.almundo.profile.api.util;

/**
 * Enum que describe los estatus manejados
 * por llamadas
 *
 * @author Yaher Carrillo
 * @Date 24/07/2018
 */
public enum EnumEstatusLlamadas
{
    LLAMADA_ENTRANTE("001", "Llamada entrante", "entrando"),
    LLAMADA_ATENDIENDOSE("002", "Llamada atendiendose", "atendiendose"),
    LLAMADA_ATENDIDA("003", "Llamada entrante", "atendiendose"),
    LLAMADA_PAUSADA("004", "Llamada Pausada", "pausa"),
    LLAMADA_CANCELADA("005", "Llamada cancelada", "cancelada"),
    LLAMADA_TERMINADA("006", "Llamada Terminada", "terminada"),
    LLAMADA_ESPERA("007", "Llamada en Espera", "esperando");

    /**
     * Codigo de la llamada
     **/
    private String code;
    /**
     * Descripcion de la llamada
     */
    private String description;
    /**
     * Status de la llamada
     */
    private String status;

    /**
     * Constructor del Enum que inicializa valores
     *
     * @param code        identificador del elemento
     * @param description ruta del recurso
     * @param status      referencia del status de la llamada
     */
    EnumEstatusLlamadas(String code, String description, String status)
    {
        this.code = code;
        this.description = description;
        this.status = status;
    }

    /**
     * Obtiene el codigo de busqueda del elemento
     *
     * @return codigo de llamada
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Asigna el codigo de lllamada
     *
     * @param code valor a asignar
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * Obtiene la desdcripcion de la llamada
     *
     * @return
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Asigna una valor a la descripcion de la llamada
     *
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Obtiene la llave de referencia del estatus
     *
     * @return
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * ASsigna un valor de la referencia de status
     *
     * @param status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
}
