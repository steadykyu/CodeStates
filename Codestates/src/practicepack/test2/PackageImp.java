package practicepack.test2;

import practicepack.test.ExampleImp; // import문 작성

// import문을 사용하지 않는 경우
//public class PackageImp {
//    public static void main(String[] args) {
//        practicepack.test.ExampleImport example = new practicepack.test.ExampleImport();
//    }
//}

public class PackageImp {
    public static void main(String[] args) {
        ExampleImp example = new ExampleImp(); // 이제 패키지명을 생략 가능
        example.print();
    }
}