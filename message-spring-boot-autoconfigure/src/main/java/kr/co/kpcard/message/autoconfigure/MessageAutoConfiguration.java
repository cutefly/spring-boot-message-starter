package kr.co.kpcard.message.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import kr.co.kpcard.message.MessageService;

@Configuration
@ConditionalOnClass(MessageService.class)
@ConditionalOnProperty("message.server-url")
@EnableConfigurationProperties(MessageProperties.class)
public class MessageAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MessageService messageSender(RestTemplate restTemplate, MessageProperties messageProperties) {
        return new MessageService(restTemplate);
    }
}
