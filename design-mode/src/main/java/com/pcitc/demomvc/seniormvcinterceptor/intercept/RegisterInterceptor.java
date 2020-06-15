package com.pcitc.demomvc.seniormvcinterceptor.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: pcitc
 * @Description:
 */
@Configuration
public class RegisterInterceptor extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FuckInterceptor());
        registry.addInterceptor(new ShitInterceptor());
        registry.addInterceptor(new ShadiaoInterceptor());
        registry.addInterceptor(new LzInterceptor());
        super.addInterceptors(registry);
    }
}
