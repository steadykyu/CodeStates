package app;

import app.MartService.AppConfig;
import app.MartService.MartApp;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MartApp martApp = new MartApp(
                                appConfig.customerRepository(),
                                appConfig.phoneInfo(),
                                appConfig.discount(),
                                appConfig.removedRepository()
        );
//        System.out.println(martApp.getCustomerRepository().findAll());
        martApp.start();
    }
}
