package config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import config.security.SecurityConfig;


public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	public SpringSecurityInitializer(){
		super(SecurityConfig.class);
	}
}
