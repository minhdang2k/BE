package com.example.accountmanagement.security;

import com.example.accountmanagement.constant.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] WHITE_LIST = {
            "/access-denied",
            "/user/home",
            "/uploads/**",
            "/assets/**",
            "/api/v1/account/**",
            "/api/v1/auth/**",
            "/"
    };
    private final JwtRequestFilter jwtRequestFilter;

    private final JwtUserDetailsService jwtUserDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
//        return (request, response, authException) -> response.sendRedirect("/access-denied");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers(WHITE_LIST).permitAll()
                .antMatchers("/api/v1/account/**").authenticated()
                .antMatchers("/admin/**")
                .hasAuthority(Role.ADMIN.name())
                .antMatchers("/user/**")
                .hasAuthority(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Không sử dụng session lưu lại trạng thái của principal
                .and()
                // Lớp lọc jwt token sẽ được thực thi trước các lớp lọc mặc định
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling();
//                .authenticationEntryPoint(customAuthenticationEntryPoint());
//                .accessDeniedPage("/access-denied");
    }
}
