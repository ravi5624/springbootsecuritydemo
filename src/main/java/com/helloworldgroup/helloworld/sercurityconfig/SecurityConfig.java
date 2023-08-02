package com.helloworldgroup.helloworld.sercurityconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig   {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
//        UserDetails normalUserDetails = User.withUsername("ravi").password(passwordEncoder().encode("normal")).roles("NORMAL").build();
//        UserDetails adminUserDetails = User.withUsername("ayu").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(normalUserDetails, adminUserDetails);
        return new MyUserDetailService();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/open/hello")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
        return http.build();

    }
}
