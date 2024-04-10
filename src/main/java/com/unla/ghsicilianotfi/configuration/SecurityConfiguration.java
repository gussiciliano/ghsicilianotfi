package com.unla.ghsicilianotfi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.unla.ghsicilianotfi.services.implementation.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

	private final UserService userService;

	public SecurityConfiguration(UserService userService) {
		this.userService = userService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.cors(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/css/*", "/imgs/*", "/js/*", "/vendor/bootstrap/css/*",
							"/vendor/jquery/*", "/vendor/bootstrap/js/*").permitAll();
					auth.anyRequest().authenticated();
				})
				.formLogin(login -> {
					login.loginPage("/login");
					login.loginProcessingUrl("/loginprocess");
					login.usernameParameter("username");
					login.passwordParameter("password");
					login.defaultSuccessUrl("/loginsuccess");
					login.permitAll();
				})
				.logout(logout -> {
					logout.logoutUrl("/logout");
					logout.logoutSuccessUrl("/logout");
					logout.permitAll();
				})
				.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userService);
		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

    /*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}*/

    /*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.requestMatchers("/css/*", "/imgs/*", "/js/*", "/vendor/bootstrap/css/*",
						"/vendor/jquery/*", "/vendor/bootstrap/js/*").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/loginsuccess").permitAll()
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
		return http.build();
	}*/

    /* No usado en este ejemplo
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }*/
}

