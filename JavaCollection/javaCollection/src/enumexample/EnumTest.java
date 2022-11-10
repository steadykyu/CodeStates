package enumexample;

enum Level {
    LOW, // 0
    MEDIUM, // 1
    HIGH, // 2
//    PI(3.14);

//    private final int value;
//    enumexample.Level(int value){
//        this.value = value;
//    }
//
//    public int getValue() {
//        return value;
//    }
}
public class EnumTest {
    public static void main(String[] args) {
        Level level = Level.MEDIUM;

        Level[] allLevels = Level.values();
        for(Level x : allLevels){
            System.out.printf("%s=%d%n",x.name(),x.ordinal());
        }

        System.out.println("--------------------");
        Level findLevel = Level.valueOf("LOW");
        System.out.println(findLevel);               // LOW
        System.out.println(Level.LOW == Level.valueOf("LOW")); // true

        System.out.println("--------------------");
        switch (level) {
            case LOW:
                System.out.println("낮은 레벨");
                break;
            case MEDIUM:
                System.out.println("중간 레벨");
                break;
            case HIGH:
                System.out.println("높은 레벨");
                break;
        }
    }
}
