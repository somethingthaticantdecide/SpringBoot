package edu.school21.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public StrictHttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowedHeaderNames((header) -> true);
        firewall.setAllowedHeaderValues((header) -> true);
        firewall.setAllowedParameterNames((parameter) -> true);
        return firewall;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/admin/panel/films/add").hasRole("ADMIN")
                .antMatchers("/profile").authenticated()
                .antMatchers("/sessions/**").authenticated()
                .antMatchers("/films/*/chat/messages").authenticated()
                .antMatchers("/films/*/chat").authenticated()
                .antMatchers("/uploadAvatar").authenticated()
                .antMatchers("/", "/img/**", "/js/**", "/css/**").permitAll()
                .antMatchers("/signUp", "/signIn").permitAll()
                .antMatchers("/chat", "/topic", "/app",  "/app/**","/app/**", "/topic/messages").permitAll()
                .antMatchers("/chat/**", "/topic/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/signIn").permitAll()
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
    }
}
