/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.configuration.spring.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailsServiceCustomLogin extends UserDetailsService
{
    public String getLoginUser();

    public void setLoginUser(String loginUser);

}
