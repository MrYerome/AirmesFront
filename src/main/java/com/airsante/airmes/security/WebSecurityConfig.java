package com.airsante.airmes.security;

import com.airsante.airmes.utils.CustomPasswordEncoder;
import com.airsante.airmes.utils.StoreSession;
import com.airsante.airmes.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author jerome.vinet
 * @since 2019.03.28
 */

@Configuration
@EnableWebSecurity
@SessionAttributes("token")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    /**
     * Définition des méthodes pour être en relation avec la base de données
     *
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(new CustomPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Permet d'ignorer la sécurité pour le dossiers ressources
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    /**
     * Définit les comportements suite à l'action / login
     * Définit les accès selon les rôles de Spring Security
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/*.js", "/*.css").permitAll()
                .antMatchers("/patient/**").authenticated()
                .antMatchers("/personne/**").authenticated()
                .antMatchers("/adresse/**").authenticated()
                .antMatchers("/prescripteur/**").access("hasAnyRole('ADMIN', 'PRESCRIPTEUR')")
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        // Réécupération et stockage du token
                        String token = Token.getTokenApi();
                        StoreSession.storeToken(request.getSession(), token);
                        //Récupération et stockage du username
                        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                        String username = "";
                        if (principal instanceof UserDetails) {
                            username = ((UserDetails) principal).getUsername();
                        } else {
                            username = principal.toString();
                        }
                        StoreSession.storeIdentifiant(request.getSession(), username);
                        String redirection = null;

                        if (redirection == null) {
                            for (GrantedAuthority gt : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
                                System.out.println(gt.getAuthority());
                                switch (gt.getAuthority()) {
                                    case "ROLE_ADMIN":
                                        redirection = "/admin";
                                        break;
                                    case "ROLE_AIRSANTE":
                                        redirection = "/";
                                        break;
                                    case "ROLE_PRESCRIPTEUR":
                                        redirection = "/prescripteur/index";
                                        break;
                                    case "ROLE_PATIENT":
                                        redirection = "/";
                                        break;
                                    default:
                                        redirection = "/";
                                        break;
                                }
                            }
                        }
                        redirectStrategy.sendRedirect(request, response, redirection);
                    }
                })
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
                .and()
                .logout()
                .permitAll();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}