package app;

import app.MartService.MartApp;
import app.tax_service.TaxService;

public class Main {
    public static void main(String[] args) {
        MartApp martApp = new MartApp();
        TaxService taxService = new TaxService();

        martApp.start();
        taxService.taxService();
    }
}
