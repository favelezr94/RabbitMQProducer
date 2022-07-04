package co.com.requiem.rabbitmqproducer.controller;

import co.com.requiem.rabbitmqproducer.config.RabbitMQProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
@RequiredArgsConstructor
@EnableConfigurationProperties(RabbitMQProperties.class)
public class RabbitMQController {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQProperties rabbitMQProperties;

    @GetMapping()
    public ResponseEntity<String> sendRabbitMessage() {
        System.out.println("Sending message with rabbit");
        rabbitTemplate.convertAndSend(rabbitMQProperties.getExchange(), "r.testRoutingKey.test", "Hello World From RabbitMQ!");
        return ResponseEntity.ok().body("Rabbit hello world sent");
    }
}
