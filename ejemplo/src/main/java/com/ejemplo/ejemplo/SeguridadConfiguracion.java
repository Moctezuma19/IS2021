package com.ejemplo.ejemplo;

import com.ejemplo.ejemplo.servicio.DetalleUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion extends WebSecurityConfigurerAdapter {

    @Autowired
    private DetalleUsuarioServicio detalleUsuarioServicio;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/registro", "/css/**", "/fonts/**", "/images/**",
                        "/js/**", "/favicon.ico", "/iniciar-sesion", "/crea")
                .permitAll().antMatchers("/").hasRole("ADMIN")
                .anyRequest().hasRole("USUARIO")//authenticated()
                .and()
                .formLogin().loginPage("/iniciar-sesion")
                .loginProcessingUrl("/iniciar-sesion").usernameParameter("nombre").passwordParameter("clave")
                .defaultSuccessUrl("/").permitAll()
                .and()
                .logout()// logout configuration
                .logoutUrl("/salir")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/iniciar-sesion").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService((UserDetailsService) detalleUsuarioServicio).passwordEncoder(passwordEncoder);
    }
}
