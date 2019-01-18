package com.example.update_with_servise_2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/about").setViewName("about");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String pathToFolder = System.getProperty("user.home") + File.separator + "images" + File.separator;
        registry.addResourceHandler("/ava/**").addResourceLocations("file:///" + pathToFolder);

        String pathToFolder2 = System.getProperty("user.home") + File.separator + "staticx" + File.separator;
        registry.addResourceHandler("/css/**").addResourceLocations("file:///" + pathToFolder2);
    }
}
