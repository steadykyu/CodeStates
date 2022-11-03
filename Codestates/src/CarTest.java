public class CarTest {
    public static void main(String[] args) {
        Car redCar = new Car();
        Car blueCar = new Car();

        // 앗! 자동차바퀴는 1개가 아닌 4개를 가지고 있으므로 4로 수정해주자.
        redCar.wheel = 4;
        System.out.println(Car.wheel);      //4
        System.out.println(redCar.wheel);   //4
        System.out.println(blueCar.wheel);  //4

        //개별 차(인스턴스)의 색은 다르므로, 각각 지정해주자.
        redCar.color = "red";
        blueCar.color = "blue";
        System.out.println(redCar.color);  //red
        System.out.println(blueCar.color); //blue
    }
}

class Car{
    public String color;         // 인스턴스
    public static int wheel = 1; // static 변수

}
