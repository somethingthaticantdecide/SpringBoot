package edu.school21.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/profile", "/profile/**").hasAnyRole("ADMIN", "USER")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/img/**", "/js/**", "/css/**", "/sessions/**", "/films", "/films/**/image").authenticated()
                .antMatchers("/signUp").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/signIn")
                .defaultSuccessUrl("/redirect")
                .and()
            .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .permitAll()
                .logoutSuccessUrl("/");
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
