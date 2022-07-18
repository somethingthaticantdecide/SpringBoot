package edu.school21.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/profile").fullyAuthenticated()
                .antMatchers("/sessions/**").fullyAuthenticated()
                .antMatchers("/films/*/chat/messages").fullyAuthenticated()
                .antMatchers("/films/*/chat").fullyAuthenticated()
                .antMatchers("/uploadAvatar").fullyAuthenticated()
                .antMatchers("/", "/img/**", "/js/**", "/css/**").permitAll()
                .antMatchers("/signUp", "/signIn").permitAll()
                .anyRequest().authenticated()
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
