package app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import app.Interceptor.AdminInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AdminInterceptor())
			.addPathPatterns("/admin/**")
			.excludePathPatterns("/**/css/**/")
			.excludePathPatterns("/**/fonts/**/")
			.excludePathPatterns("/**/img/**/")
			.excludePathPatterns("/**/js/**/")
			.excludePathPatterns("/**/vendor/**/");
	}
	
}
