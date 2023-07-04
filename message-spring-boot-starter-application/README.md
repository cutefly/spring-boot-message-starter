# Message Sender

## project 구성

```xml
#pom.xml에 dependency 추가
<dependency>
    <groupId>kr.co.kpcard.springboot.starter</groupId>
    <artifactId>message-spring-boot-starter</artifactId>
    <version>2.7.13-SNAPSHOT</version>
</dependency>
```

## 환경설정

```properties
# application.properties에 서버설정 추가
message.server-url=https://message.kpcard.co.kr/
message.service-id=mobilepop
```

## 메세지 전송

```java
# MessageService 구현부

public class MessageApplication {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/")
	public String Hello() {
		MessageDT messageDT = MessageDT.builder()
			.templateId("exipire.cash")
			.receiver("chris@kpcard.co.kr")
			.subject("캐시 유효기간 만료")
			.text("<html></html>")
			.build();
		messageService.send(messageDT);
		return "hello";
	}
}
```
