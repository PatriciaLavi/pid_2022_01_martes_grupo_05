package com.empresa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.empresa.util.LoginSuccessMessege;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	

	@Autowired
	private BCryptPasswordEncoder passEnconder;
	
	@Autowired
	private LoginSuccessMessege message;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/index", "/home", "/", "/css/**", "/js/**", "/images/**").permitAll()
				/*
				 * .antMatchers("/views/vistante/").hasAnyRole("USER")
				 * .antMatchers("/views/vistante/registrar").hasAnyRole("USER")
				 * .antMatchers("/views/vistante/save").hasAnyRole("USER")
				 * .antMatchers("/views/vistante/edit/**").hasAnyRole("ADMIN")
				 * .antMatchers("/views/vistante/delete/**").hasAnyRole("ADMIN")
				 */
				.anyRequest().authenticated()
				.and().formLogin()
				 	.successHandler(message)
				     .loginPage("/login")
				.permitAll()
				.and().logout().permitAll();
	}

	@Autowired
	public void configurerSecurityGobal(AuthenticationManagerBuilder builder) throws Exception {

		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passEnconder)
				.usersByUsernameQuery("SELECT u.username, u.password, u.enable FROM users u WHERE u.username =?")
				.authoritiesByUsernameQuery(
						"SELECT r.user_id, r.rolname FROM roles r inner join users u on r.user_id=u.id where u.username=?");

	}

}
