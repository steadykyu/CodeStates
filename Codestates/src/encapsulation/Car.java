package encapsulation;

 class Car {

    private String name;
    private int fuelPercent;

    public Car(String name, int fuelPercent) {
        this.name = name;
        this.fuelPercent = fuelPercent;
    }

    public String getName() {
        return name;
    }

     public void on() {
         System.out.println("시동을 겁니다. 부릉~");
     }

     public void go() {
         System.out.println("부릉부릉");
     }

     public void off() {
         System.out.println("시동을 끕니다. ");
     }
//
//    private void on() {
//        System.out.println("시동을 겁니다. 부릉~");
//    }
//
//    private void go() {
//        System.out.println("부릉부릉");
//    }
//
//    private void off() {
//        System.out.println("시동을 끕니다. ");
//    }

//    public void operate() {
//        if (fuelPercent <= 0)
//            System.out.println("연료가 부족하여 시동을 걸 수 없습니다. ");
//        else {
//            on();
//            go();
//            off();
//        }
//    }
}
