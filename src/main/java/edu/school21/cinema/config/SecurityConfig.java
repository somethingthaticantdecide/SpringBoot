package edu.school21.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public StrictHttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowedHeaderValues((header) -> true);
        return firewall;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/admin/panel/films/add").hasRole("ADMIN")
                .antMatchers("/profile").fullyAuthenticated()
                .antMatchers("/sessions/**").fullyAuthenticated()
                .antMatchers("/films/*/chat/messages").fullyAuthenticated()
                .antMatchers("/films/*/chat").fullyAuthenticated()
                .antMatchers("/uploadAvatar").fullyAuthenticated()
                .antMatchers("/chat", "/topic", "/app", "/app/**","/app/**", "/topic/messages").authenticated()
                .antMatchers("/chat/**", "/topic/**").authenticated()
                .antMatchers("/confirm/*").permitAll()
                .antMatchers("/", "/img/**", "/js/**", "/css/**").permitAll()
                .antMatchers("/signUp", "/signIn").permitAll()
                .antMatchers("/denied").permitAll()
                .anyRequest().authenticated()
                .and()
                .rememberMe()
                .tokenValiditySeconds(3600)
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .deleteCookies("remember-me")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/");
        return http.build();
    }
}
