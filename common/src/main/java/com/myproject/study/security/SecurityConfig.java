package com.myproject.study.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.study.security.filters.FormLoginFilter;
import com.myproject.study.security.filters.JwtAuthenticationFilter;
import com.myproject.study.security.filters.SocialLoginFilter;
import com.myproject.study.security.handlers.FormLoginAuthenticationSuccessHandler;
import com.myproject.study.security.handlers.JwtAuthenticationFailureHandler;
import com.myproject.study.security.providers.FormLoginAuthenticationProvider;
import com.myproject.study.security.providers.JwtAuthenticationProvider;
import com.myproject.study.security.providers.SocialLoginAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FormLoginAuthenticationSuccessHandler formLoginAuthenticationSuccessHandler;

    @Autowired
    private FormLoginAuthenticationProvider provider;

    @Autowired
    private JwtAuthenticationProvider jwtProvider;

    @Autowired
    private JwtAuthenticationFailureHandler jwtFailureHandler;

    @Autowired
    private HeaderTokenExtractor headerTokenExtractor;

    @Autowired
    private SocialLoginAuthenticationProvider socialLoginAuthenticationProvider;

    @Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();

    }

    protected FormLoginFilter formLoginFilter() throws Exception {
        FormLoginFilter filter = new FormLoginFilter("/formlogin",formLoginAuthenticationSuccessHandler,null);
        filter.setAuthenticationManager(super.authenticationManagerBean());

        return filter;
    }

    protected JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        FilterSkipMatcher matcher = new FilterSkipMatcher(Arrays.asList("/formlogin","/social"),"/api/**");
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(matcher,jwtFailureHandler,headerTokenExtractor);
        filter.setAuthenticationManager(super.authenticationManagerBean());

        return filter;
    }

    protected SocialLoginFilter socialLoginFilter() throws Exception{
        SocialLoginFilter filter = new SocialLoginFilter("/social",formLoginAuthenticationSuccessHandler);
        filter.setAuthenticationManager(super.authenticationManagerBean());

        return filter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(this.provider)
                .authenticationProvider(this.jwtProvider)
                .authenticationProvider(this.socialLoginAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .csrf().disable()
                .cors().disable()
                .formLogin().disable()
                .headers().frameOptions().disable();

        http
                .addFilterBefore(corsFilter(), SessionManagementFilter.class)
                .addFilterBefore(formLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(socialLoginFilter(),UsernamePasswordAuthenticationFilter.class);
    }
}
