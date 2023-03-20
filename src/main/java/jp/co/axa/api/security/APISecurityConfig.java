package jp.co.axa.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class APISecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		  http .csrf().disable()
		  .httpBasic()   
		  
          .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)   
          .and().authorizeRequests()
          .antMatchers(
        		  "/v2/api-docs", 
                  "/swagger-resources/**",  
                  "/swagger-ui.html", 
                  "/webjars/**").permitAll()
          .anyRequest().authenticated();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
		 web.ignoring().antMatchers("/h2-console/**", "/v2/api-docs",
                 "/configuration/ui",
                 "/swagger-resources/**",
                 "/configuration/security",
                 "/swagger-ui.html",
                 "/webjars/**");
    }
}
