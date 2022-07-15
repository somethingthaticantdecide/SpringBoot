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
                .antMatchers("/admin/panel/*").hasRole("ADMIN")
                .antMatchers("/admin/panel").hasRole("ADMIN")
                .antMatchers("/profile").hasRole("USER")
                .antMatchers("/sessions/search").hasRole("USER")
                .antMatchers("/films/*/chat/messages").hasRole("USER")
                .antMatchers("/films/*/chat").hasRole("USER")
                .antMatchers("/signUp", "/signIn").permitAll()
//                .antMatchers("/*").permitAll()
//                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/signIn").permitAll()
                .and()
                .rememberMe();
    }
}
