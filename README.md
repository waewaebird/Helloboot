# Helloboot

Request
- Request Line : Method, Path, HTTP Version
- Headers
- Message Body

Response
- Status Line : HTTP Version, Status Code, Status Text
- Headers
- Message Body

DI (Spring IoC/DI Container)
HelloController가 의존하고 있다(다른 클래스의 기능을 사용하고 있다) ----> SimpleHelloService
                                                                 ComplexHelloService
바꾸기 쉽지 않으니깐.


HelloController ---->   HelloService(Interface)
                        |                    |
                SimpleHelloService     ComplexHelloService

HelloController <Assembler=Spring Container> SimpleHelloService(오브젝트 레퍼런스를 넘겨준다) = 주입해준다

1. 생성자 주입방식
2. Factory 주입 방식
3. 프로퍼티 정의 방식