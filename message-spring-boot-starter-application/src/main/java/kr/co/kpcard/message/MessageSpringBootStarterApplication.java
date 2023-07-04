package kr.co.kpcard.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MessageSpringBootStarterApplication {

	@Autowired
	private MessageService messageService;
	
	public static void main(String[] args) {
		SpringApplication.run(MessageSpringBootStarterApplication.class, args);
	}

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
