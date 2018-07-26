/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */

package co.almundo.profile.api.util;

/**
 * Enum que describe el manejo
 * de los servicios de almundo.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public enum EnumServicesAlmundoConfig
{
    SERVICES_USERS("servicio.usuarios", "usuariosServiceImpl"),
    SERVICES_USERS_PROXY("servicio.usuarios.proxy", "proxyUsuariosService"),
    SERVICES_ENCRYPT_PASS("servicio.password.encrypt", "passwordEncoder"),
    SERVICES_AUTH_SPRING("servicio.password.encrypt.spring", "org.springframework.security.authenticationManager"),
    SERVICES_SALAS("servicio.salas.almundo", "salasLlamadasServicesImpl"),
    SERVICES_DEFAILT("servicio.default", "usuariosServiceDefault");
    /**
     * Codigo del sexo
     **/
    private String code;
    /**
     * nombre del servicio expuesto por spring
     */
    private String nameService;

    /**
     * Constructor del Enum que inicializa valores
     *
     * @param code        identificador del elemento
     * @param nameService descripcion del recurso
     */
    EnumServicesAlmundoConfig(String code, String nameService)
    {
        this.code = code;
        this.nameService = nameService;
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
     * Asigna el codigo a un elemento.
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
    public String getNameService()
    {
        return nameService;
    }

    /**
     * Asigna una valor a la descripcion del error
     *
     * @param nameService
     */
    public void setNameService(String nameService)
    {
        this.nameService = nameService;
    }
}
