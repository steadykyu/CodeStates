package enumexample;//class enumexample.Seasons {
//    public static final enumexample.Seasons SPRING = new enumexample.Seasons();
//    public static final enumexample.Seasons SUMMER = new enumexample.Seasons();
//    public static final enumexample.Seasons FALL   = new enumexample.Seasons();
//    public static final enumexample.Seasons WINTER = new enumexample.Seasons();
//}

enum Seasons {SPRING, SUMMER, FALL, WINTER}

public class Main {
    public static void main(String[] args) {
        Seasons seasons = Seasons.SPRING;
        switch(seasons){
            case SPRING:
                System.out.println("봄");
                break;
            case SUMMER:
                System.out.println("여름");
                break;
            case FALL:
                System.out.println("가을");
                break;
            case WINTER:
                System.out.println("겨울");
                break;
        }

        // Operator '==' cannot be applied to 'enumexample.Seasons', 'Frameworks'
//        enumexample.Seasons.SPRING == Frameworks.SPRING

//        System.out.println(enumexample.Seasons.SPRING);

        Seasons favoriteSeason = Seasons.SPRING;
        System.out.println(favoriteSeason);
    }
}