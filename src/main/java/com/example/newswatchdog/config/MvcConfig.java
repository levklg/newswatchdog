package com.example.newswatchdog.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.example.newswatchdog")
public class MvcConfig implements WebMvcConfigurer {

    @Override
     public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("forward:/index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/img").setViewName("img");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController( "/").setViewName("userconsole");
        registry.addViewController( "/userconsole").setViewName("userconsole");
        registry.addRedirectViewController("/", "/");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/templates/**").addResourceLocations("/templates/");
    }



}
