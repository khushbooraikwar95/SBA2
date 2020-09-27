package com.eval.coronakit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		UserBuilder builder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(builder.username("Admin").password("admin").roles("ADMIN"))
		.withUser(builder.username("First").password("abc").roles("USER"))
		.withUser(builder.username("Second").password("abc").roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/console/**").permitAll();
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasRole("USER");

		http.formLogin().loginPage("/validate").usernameParameter("username").passwordParameter("password")
		.failureUrl("/custom-error").defaultSuccessUrl("/home");
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
		http.exceptionHandling().accessDeniedPage("/custom-error");
		
		http.csrf().disable();
		http.headers().frameOptions().disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}
