package com.franciscob.demo_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor timeInterceptor;

    public void addInterceptor(InterceptorRegistry registry){
        registry.addInterceptor(timeInterceptor);
    }
}
