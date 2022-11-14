package lambda;

//lambda.Member.java
public class Member {
    private String name;
    private String id;

    public Member() {
        System.out.println("lambda.Member() 실행");
    }

    public Member(String id) {
        System.out.println("lambda.Member(String id) 실행");
        this.id = id;
    }

    public Member(String name, String id) {
        System.out.println("lambda.Member(String name, String id) 실행");
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}