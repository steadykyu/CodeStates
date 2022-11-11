public class Main {
    public static void main(String[] args) {
        // Iphone , GalaxyPhone이 있고 둘다 1,000,000 원이다.
        Mart mart = new Mart(new Iphone(1000000), new GalaxyPhone(1000000));

        mart.start();
        }
}
