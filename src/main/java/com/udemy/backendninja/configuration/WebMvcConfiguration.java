package com.udemy.backendninja.configuration;

import com.udemy.backendninja.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    @Qualifier("requestTimeInterceptor")
    private RequestTimeInterceptor requestTimeInterceptor;
//
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//      registry.addInterceptor(requestTimeInterceptor).addPathPatterns("/**"); // o los paths que quieras interceptar
      registry.addInterceptor(requestTimeInterceptor).addPathPatterns("/**"); // o los paths que quieras interceptar
    }
}
