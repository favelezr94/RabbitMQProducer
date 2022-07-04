package co.com.requiem.rabbitmqproducer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "rabbit-properties")
public class RabbitMQProperties {
    private String queue;
    private String routingKey;
    private String exchange;
}
