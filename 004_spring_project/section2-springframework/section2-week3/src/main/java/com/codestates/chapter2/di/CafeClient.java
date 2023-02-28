package com.codestates.chapter2.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class CafeClient {
    public static void main(String[] args) {
        MenuService menuService = new MenuServiceStub();
//        MenuService menuService = new MenuServiceImpl();
        MenuController controller = new MenuController(menuService);
        List<Menu> menuList = controller.getMenus();
        System.out.println(menuList);
    }
}


