package com.residentevil.configuration;

import com.residentevil.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(getBCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/bootstrap/**", "/jquery/**", "/register").permitAll()
                .antMatchers("/viruses/**").hasAnyRole("ADMIN", "CHEMIST")
                .antMatchers("/cures/**").access("hasRole('ADMIN') or hasRole('MEDIC')")
                .antMatchers("/users/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and()
                .formLogin().loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
            .and()
                .rememberMe()
                .rememberMeParameter("rememberMe")
                .key("Taina")
                .tokenValiditySeconds(604_800)
            .and()
                .logout().logoutSuccessUrl("/login?logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("users/logout")).permitAll()
            .and()
                .exceptionHandling().accessDeniedPage("/noaccess")
            .and()
                .csrf()
                .csrfTokenRepository(csrfTokenRepository());

    }

    public CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }
}
