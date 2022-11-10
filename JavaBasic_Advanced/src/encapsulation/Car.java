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

    // 캡슐화 되지 않은 코드
     // 만약 자동차 로직이 변경시, 이 메서드들을 호출한 객체의 소스코드도 전부 수정해야함
     // ex) on - go - off 에서 on - 창문열고 - 물 한번닦고 - go() - stop() - off()
     public void on() {
         System.out.println("시동을 겁니다. 부릉~");
     }

     public void go() {
         System.out.println("부릉부릉");
     }

     public void off() {
         System.out.println("시동을 끕니다. ");
     }


     // 캡슐화 된 코드 - 자동차 로직을 모두 operate()에 묶어둠.
     // operate() 호출자들은 내부 로직을 모른채 호출.
     // 자동차 로직 변경시, operate()만 수정하면 된다. 메서드를 호출하는 객체들은
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
