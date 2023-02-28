package com.codestates.chapter2.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

// Java 콘솔 어플리케이션으로 구현한 Spring
public class CafeClientBySpring {
    public static void main(String[] args) {
        GenericApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        MenuController controller = context.getBean(MenuController.class);

        List<Menu> menuList = controller.getMenus();
        System.out.println(menuList);
    }

}
