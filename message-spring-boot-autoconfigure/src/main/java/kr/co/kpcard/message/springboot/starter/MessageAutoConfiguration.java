package kr.co.kpcard.message.springboot.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnClass()
@ConditionalOnProperty("")
@EnableConfigurationProperties(MessageProperties.class)
public class MessageAutoConfiguration {

    @Bean
    //@ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MessageSender messageSender(RestTemplate restTemplate, MessageProperties messageProperties) {
        return new MessageSender(restTemplate);
    }
}
