package com.boots.carsales.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
//        Для страниц, которые никак не обрабатываются сервером, а просто возвращают страницу
//Страница login обрабатывается Spring Security контроллером по умолчанию, поэтому для неё отдельный контроллер не требуется
//        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/news").setViewName("news");
    }
}
