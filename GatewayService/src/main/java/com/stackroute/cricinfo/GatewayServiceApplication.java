package com.stackroute.cricinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.stackroute.cricinfo.filter.JwtFilter;

@SpringBootApplication
@EnableZuulProxy
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> jwtFilter = new FilterRegistrationBean<JwtFilter>();
		jwtFilter.setFilter(new JwtFilter());
		jwtFilter.addUrlPatterns("/favouriteservice/cricinfo/cricmatch/*");
		return jwtFilter;
	}
	
}
