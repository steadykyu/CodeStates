# 트랜잭션 레퍼런스 코드

### Description
트랜잭션 레퍼런스 코드는 유어클래스 컨텐츠에서 사용되는 코드 + 라이브 세션에서 사용되는 예제 코드로 구성되어 있습니다.
* 라이브 세션용 예제 코드
  * [프록시(Proxy) 예제 코드](#프록시proxy-예제-코드)
  * [다이나믹 프록시(Dynamic Proxy) 예제 코드](#다이나믹-프록시dynamic-proxy-예제-코드)
  * [리플렉션(Reflection) 예제 코드](#리플렉션reflection-예제-코드)
  * [ProxyFactoryBean 예제 코드](#proxyfactorybean-예제-코드)
  
> 예제 코드에 대한 더 구체적인 정보는 아래에서 확인하세요.

---

### 프록시(Proxy) 예제 코드
Java의 인터페이스를 이용해 프록시의 동작 과정을 이해하기 위한 예제 코드입니다.
* 소스 코드 경로
  * [src/main/java/com/codestates/proxy_example/proxy](https://github.com/codestates-seb/be-reference-tx/tree/main/src/main/java/com/codestates/proxy_example/proxy)

---

### 다이나믹 프록시(Dynamic Proxy) 예제 코드
Java의 다이나믹 프록시(Dynamic Proxy)를 이용해 동적 프록시를 생성하는 예제 코드입니다.
* 소스 코드 경로
  * [src/main/java/com/codestates/proxy_example/dynamic_proxy](https://github.com/codestates-seb/be-reference-tx/tree/main/src/main/java/com/codestates/proxy_example/dynamic_proxy)
  * [src/test/java/com/codestates/proxy_example/dynamic_proxy]()
---

### 리플렉션(Reflection) 예제 코드
Java의 리플렉션(Reflection)을 사용하는 예제 코드입니다.
* [src/main/java/com/codestates/proxy_example/reflection](https://github.com/codestates-seb/be-reference-tx/tree/main/src/main/java/com/codestates/proxy_example/reflection)

---

### ProxyFactoryBean 예제 코드
Spring의 ProxyFactoryBean을 이용해 프록시를 생성하는 예제 코드입니다. Spring의 ProxyFactoryBean을 이용하면 프록시를 Spring Bean으로 등록할 수 있습니다.
* 인터페이스 기반의 Proxy 생성(Dynamic Proxy 방식)
  * 소스 코드 경로
    * [src/main/java/com/codestates/proxy_example/proxy_factory_bean](https://github.com/codestates-seb/be-reference-tx/tree/main/src/main/java/com/codestates/proxy_example/proxy_factory_bean)
    * [src/test/java/com/codestates/proxy_example/proxy_factory_bean](https://github.com/codestates-seb/be-reference-tx/tree/main/src/test/java/com/codestates/proxy_example/proxy_factory_bean)
  * 실행 결과 확인
    * 테스트 케이스 실행으로 확인할 수 있습니다. 
* 타겟 클래스 기반의 Proxy 생성(CGLIB 방식)
  * 소스코드 경로
    * [src/main/java/com/codestates/proxy_example/proxy_factory_bean/cglib_based](https://github.com/codestates-seb/be-reference-tx/tree/main/src/main/java/com/codestates/proxy_example/proxy_factory_bean/cglib_based)
  * 실행 결과 확인
    * 애플리케이션 실행
    * 아래의 엔드포인트로 HTTP request 전송
      * http://localhost:8080/v12/members
      * request body
        * `{
          "email": "hjs6877@gmail.com",
          "password":"1111",
          "name": "홍길동1",
          "phone": "010-1111-1111"
          }`
    * IntelliJ 로그를 통해 MemberService > createMember() 호출 전 후로 아래 로그가 출력되는지 확인
      * `# Execute LogAdvice before proceeding target:...`
      * `# Execute LogAdvice after proceeding target:...`
