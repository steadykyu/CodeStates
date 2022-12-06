package com.codestates.chapter2.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CafeClientBySpring.class)
public class Config {
    @Bean
    public MenuService getMenuService() { // 객체 생성 메서드
//        return new MenuServiceStub();
        return new MenuServiceImpl();
    }

    @Bean
    public MenuController getMenuController(MenuService menuService){
        return new MenuController(menuService);
    }
}
