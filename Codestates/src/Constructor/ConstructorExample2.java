package Constructor;

public class ConstructorExample2 {
    public static void main(String[] args) {
        Car car = new Car("Model X", "빨간색", 250);
        System.out.println("제 차는 " + car.getModelName() + "이고, 컬러는 " + car.getColor() + "입니다.");
    }
}
class Car{
    private String modelName;
    private String color;
    private int maxSpeed;

    public Car(String modelName, String color, int maxSpeed) {
        this.modelName = modelName;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getModelName() {
        return modelName;
    }

    public String getColor() {
        return color;
    }
}
