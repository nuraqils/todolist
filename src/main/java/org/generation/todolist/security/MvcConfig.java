package org.generation.todolist.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        //addViewController is the route to the setViewName which is the html file name
        registry.addViewController("/").setViewName("todolist");
        registry.addViewController("/todolist").setViewName("todolist");
        registry.addViewController("/newtodo").setViewName("newtodo");


    }


    // this is to allow access to static resources (e.g. css, js, images) in the static folders
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/") // compiled classpath .class files
                .setCachePeriod(0); // this is to disable caching


    }
}
