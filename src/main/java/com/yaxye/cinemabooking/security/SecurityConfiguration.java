package com.yaxye.cinemabooking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserPrincipalDetailsService userPrincipalDetailsService;
    private final BCryptPasswordEncoder encoder;
    
    @Autowired
    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.encoder = new BCryptPasswordEncoder();
		this.userPrincipalDetailsService = userPrincipalDetailsService;
           
        }

	
	  @Override protected void configure(AuthenticationManagerBuilder auth) {
	  	auth.authenticationProvider(authenticationProvider()); }
	 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home" , "/").permitAll()
                .antMatchers("/user").hasAuthority("USER")
                .antMatchers("/booking/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/cinema/**").hasAuthority("ADMIN")
                .antMatchers("/film/**").hasAuthority("ADMIN")
                .antMatchers("/session/**").hasAuthority("ADMIN")
                .antMatchers("/row/**").hasAuthority("ADMIN")
                .antMatchers("/seat/**").hasAuthority("ADMIN")
                .antMatchers("/ticket/**").hasAuthority("ADMIN")
                .antMatchers("/ticket/showTickets").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("ADMIN")
                .antMatchers("/venue/**").hasAuthority("ADMIN")
                .and()
                .formLogin()
                .loginProcessingUrl("/signin")
                .loginPage("/login").permitAll()
                .usernameParameter("txtUsername")
                .passwordParameter("txtPassword")
                .defaultSuccessUrl("/success", true)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
                
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
}
