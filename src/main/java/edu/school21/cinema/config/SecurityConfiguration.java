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
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/auth/profile", "/auth/profile/**").hasAnyRole("ADMIN", "USER")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/img/**", "/js/**", "/css/**", "/sessions/**", "/films", "/films/**/image").permitAll()
                .antMatchers("/auth/register").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/auth/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/auth/profile")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/auth/logout")
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
