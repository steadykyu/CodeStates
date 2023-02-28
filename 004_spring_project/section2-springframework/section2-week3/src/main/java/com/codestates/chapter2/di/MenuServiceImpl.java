package com.codestates.chapter2.di;

import java.util.List;

public class MenuServiceImpl implements MenuService{
    @Override
    public List<Menu> getMenuList() {
        return List.of(
                new Menu(1,"진짜_아메리카노",2500),
                new Menu(2,"진짜_카라멜 마끼아또",4500),
                new Menu(3,"진짜_바닐라 라떼",4500)
                );
    }
}
