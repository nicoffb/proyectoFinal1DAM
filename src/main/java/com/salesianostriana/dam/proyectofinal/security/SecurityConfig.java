package com.salesianostriana.dam.proyectofinal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioRepo usuarios;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/carrito/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/lista/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and().exceptionHandling().accessDeniedPage("/auth-error")
                .and().formLogin().loginPage("/").loginProcessingUrl("/login").failureUrl("/login-error").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
        
        http.csrf().disable();

        http.headers().frameOptions().disable();

    }
  //  <img th:src = /img  > PONER BARRA DELANTE EN TODAS LAS RESOURCES DE STATIC
    //que dice de un error de cajon de sastre no sino que distintos como?
    
    
    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        usuarios.getUsuarios()
                .stream()
                .map(u -> {
                    return User
                            .withUsername(u.getUsername())
                            .password("{noop}"+ u.getPassword())
                            .roles(u.getRole())
                            .build();
                    
                    

                })
                .forEach(userDetailsManager::createUser);
        

        return userDetailsManager;


    }
}