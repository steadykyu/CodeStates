package app;

import app.MartService.MartService;
import app.tax_service.TaxService;

public class Main {
    public static void main(String[] args) {
        MartService martApp = new MartService();
        TaxService taxService = new TaxService();

        martApp.service();
        taxService.taxService();
    }
}
