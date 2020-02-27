package uni.umons.ratingwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uni.umons.ratingwebapp.security.LoggingAccessDeniedHandler;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.EnumSet;


@Configuration
@ComponentScan("uni.umons.ratingwebapp.security")
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {


		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		
		// static resources
		httpSecurity.authorizeRequests()
		.antMatchers("/css/**", "/js/**", "/images/**", "/resources/**", "/webjars/**").permitAll();
		
		httpSecurity.authorizeRequests()
						.antMatchers("/signin").anonymous()
           				//.antMatchers("/admin/**").access("hasRole('Administrator')")
						//.antMatchers("/user/**").access("hasRole('User') or hasRole('Administrator')")
						.anyRequest()
						.authenticated()
						.and()
					.formLogin()
						.loginPage("/signin")
						.loginProcessingUrl("/sign-in-process.html")
						.failureUrl("/signin?error")
						.usernameParameter("username")
						.passwordParameter("password")
						.defaultSuccessUrl("/home", false)
						.and()
					.logout()
						.logoutSuccessUrl("/signin?logout");


		httpSecurity.exceptionHandling().accessDeniedPage("/401.html");
		httpSecurity.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		httpSecurity.sessionManagement().invalidSessionUrl("/signin");
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(customUserDetailsService);
	}
	
	@Bean
	public FilterRegistrationBean getSpringSecurityFilterChainBindedToError(
	                @Qualifier("springSecurityFilterChain") Filter springSecurityFilterChain) {

	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(springSecurityFilterChain);
	        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
	        return registration;
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}


}
