package kr.co.kpcard.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessageSpringBootStarterApplication {

	private MessageSender messageSender;
	
	public static void main(String[] args) {
		SpringApplication.run(MessageSpringBootStarterApplication.class, args);
	}

	@GetMapping("/")
	public void Hello() {
		messageSender.send(null);
	}
}
