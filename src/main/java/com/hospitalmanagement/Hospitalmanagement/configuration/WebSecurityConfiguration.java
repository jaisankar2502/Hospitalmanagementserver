package com.hospitalmanagement.Hospitalmanagement.configuration;
import com.hospitalmanagement.Hospitalmanagement.security.AccessTokenProcessingFilter;
import com.hospitalmanagement.Hospitalmanagement.security.AccessTokenUserDetailsService;
import com.hospitalmanagement.Hospitalmanagement.security.config.SecurityConfig;
import com.hospitalmanagement.Hospitalmanagement.security.util.TokenGenerator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {



    public WebSecurityConfiguration() {
        super(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatcher(new NegatedRequestMatcher(new AntPathRequestMatcher("/error")))
                .addFilter(accessTokenProcessingFilter())
                .authenticationProvider(preAuthenticatedAuthenticationProvider())
                .exceptionHandling().and()
                .headers().and()
                .sessionManagement().sessionCreationPolicy(STATELESS).and()
                .securityContext().and()
                .anonymous().and()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(POST, "/login").anonymous()
                .antMatchers(PUT,"/login").anonymous()
                .antMatchers(OPTIONS, "/user").anonymous()
                .antMatchers("/user/leave/patient").anonymous()
                .antMatchers("/user/doctor/*").anonymous()
                .antMatchers(OPTIONS,"/patient").anonymous()
                .antMatchers("/patient/add").anonymous()
                .antMatchers("/patient/time/*").anonymous()
                .antMatchers("/user/patientDep").anonymous()
                .anyRequest().authenticated();
    }

    @Bean
    protected AccessTokenUserDetailsService accessTokenUserDetailsService() {
        return new AccessTokenUserDetailsService();
    }

    @Bean
    protected PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
        PreAuthenticatedAuthenticationProvider authProvider = new PreAuthenticatedAuthenticationProvider();
        authProvider.setPreAuthenticatedUserDetailsService(accessTokenUserDetailsService());
        return authProvider;
    }

    @Bean
    protected AccessTokenProcessingFilter accessTokenProcessingFilter() throws Exception {
        AccessTokenProcessingFilter filter = new AccessTokenProcessingFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @ConfigurationProperties("app.security")
    public SecurityConfig securityConfig() {
        return new SecurityConfig();
    }

    @Bean
    @ConfigurationProperties("app.security.configuration")
    public TokenGenerator tokenGenerator(SecurityConfig securityConfig) {
        return new TokenGenerator(securityConfig.getTokenGeneratorPassword(), securityConfig.getTokenGeneratorSalt());
    }
}
