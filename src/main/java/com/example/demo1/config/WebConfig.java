package com.example.demo1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//nối các file css , js ,image vào các file.jsp tươn ứng
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/Frontend/img/**").addResourceLocations("/resources/Frontend/images/");
        registry.addResourceHandler("/Frontend/css/**").addResourceLocations("/resources/Frontend/css/");
        registry.addResourceHandler("/Frontend/js/**").addResourceLocations("/resources/Frontend/js/");
    }


}

