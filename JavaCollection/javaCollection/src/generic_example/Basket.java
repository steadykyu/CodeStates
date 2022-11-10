package generic_example;

class Basket<T> {
    private T item;

    public Basket(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        Basket<String> basket1 = new Basket<String>("기타줄");
        Basket<Integer> basket2 = new Basket<Integer>(100);
        Basket<Boolean> basket3 = new Basket<Boolean>(true);
        Basket<Double> basket4 = new Basket<Double>(3.14);

        System.out.println(basket1.getItem());
        System.out.println(basket2.getItem());
        System.out.println(basket3.getItem());
        System.out.println(basket4.getItem());
    }
}
