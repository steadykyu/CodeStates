package enumexample;

enum Direction {
    EAST(1), SOUTH(5), WEST(-1), NORTH(10);

    private final int value; // 정수를 저장할 필드(인스턴스 변수) 추가
    Direction(int value) {this.value = value;}

    public int getValue() {return value;}
}

public class EnumExample2 {
    public static void main(String[] args) {
        System.out.println(Direction.SOUTH);
        System.out.println(Direction.SOUTH.getValue());

        System.out.println("-".repeat(50));
        for(Direction d : Direction.values()) {
            System.out.printf("%s=%d%n", d.name(), d.getValue());
        }

    }
}
