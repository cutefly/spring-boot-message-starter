package kr.co.kpcard.message.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "message")
public class MessageProperties {

	private String serverUrl;
	private String serviceId;
}
