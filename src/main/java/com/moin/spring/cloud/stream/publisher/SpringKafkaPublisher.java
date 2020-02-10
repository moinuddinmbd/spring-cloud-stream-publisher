package com.moin.spring.cloud.stream.publisher;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
@Api(value = "KafkaPublisherServices")
public class SpringKafkaPublisher {

    @Autowired
    private MessageChannel output;

    @PostMapping("/publish")
    @ApiOperation(value = "publishMessage", httpMethod = "POST", response = String.class, notes = "This service will publish messages to Kafka topic.")
    public String publishMessage(@RequestBody String data) {
        output.send(MessageBuilder.withPayload(data).build());
        return "message published successfully";
    }
}
