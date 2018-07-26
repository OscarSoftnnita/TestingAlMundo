/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.configuration.hibernate;

import co.almundo.profile.api.services.SalasLlamadasServices;
import co.almundo.profile.api.services.UsuariosService;
import co.almundo.profile.impl.proxys.ProxyUsuariosServiceImpl;
import co.almundo.profile.impl.service.SalasLlamadasServicesImpl;
import co.almundo.profile.impl.service.UsuariosServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * En esta clase se definen los bean de servicios
 * cuando sean multiples implementaciones, en pro
 * de diferenciarlos por su nombre y retornar segun sea necesario.
 * Para esto es importante la implementacion de proxys donde
 * a traves de un criterio, se implementen los requeridos.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Configuration
public class BeanServicesConfig
{
    /**
     * Bean que define el proxy de operaciones de usuarios
     *
     * @return Bean de servicio de usuarios segun el proxy
     */
    @Bean
    @Primary
    public UsuariosService proxyUsuariosServiceImpl()
    {
        return new ProxyUsuariosServiceImpl();
    }

    /**
     * Bean que las operaciones principales de usuarios.
     *
     * @return Bean original de implementacion
     */
    @Bean
    public UsuariosService usuariosServiceImpl()
    {
        return new UsuariosServiceImpl();
    }

    /**
     * Bean que las operaciones principales de las salas de atenciones
     *
     * @return Bean original de implementacion
     */
    @Bean
    public SalasLlamadasServices salasLlamadasServicesImpl()
    {
        return new SalasLlamadasServicesImpl();
    }

    /**
     * Bean con el listado de mapeo de los servicio de referencias de usuarios
     *
     * @return
     */
    @Bean
    public ServicesReferencesMapping beansUsersHandlers()
    {
        return new ServicesReferencesMapping();
    }
}
