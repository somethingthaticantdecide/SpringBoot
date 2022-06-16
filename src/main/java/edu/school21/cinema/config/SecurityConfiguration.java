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
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/signUp", "/signIn").permitAll();
        http.csrf().disable();
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/profile", "/profile/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/", "/images/**", "/sessions/**", "/films").authenticated()
//                .antMatchers("/signUp", "/signIn").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .defaultSuccessUrl("/default")
//                .loginPage("/")
//                .failureUrl("/")
//                .and()
//            .logout()
//                .logoutUrl("/logout")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .permitAll()
//                .logoutSuccessUrl("/")
//                .and()
//            .rememberMe()
//                .tokenValiditySeconds(3600);
//        return http.build();
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
