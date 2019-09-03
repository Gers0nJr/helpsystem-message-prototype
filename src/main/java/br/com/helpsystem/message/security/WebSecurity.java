package br.com.helpsystem.message.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	@Override
	public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web)
			throws Exception {
		
		web.ignoring()
		.antMatchers("/bootstrap/**")
		.antMatchers("/css/**")
		.antMatchers("/js/**");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/message").hasAnyRole("ADM","CLIENTE")
			.antMatchers("/usuarios").hasAnyRole("ADM","CLIENTE")
			.antMatchers("/mensagens").hasAnyRole("ADM","CLIENTE")
			//.antMatchers("/mensagens/nlidas").hasAnyRole("ADM","CLIENTE")
			.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/message")
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true) 
		.and()
		.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
