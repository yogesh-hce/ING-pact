package io.pivotal.microservices.pact.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class Application {

    @Autowired
    ConsumerPort consumerPort;

    @RequestMapping("/testUrl")
    public List<TestView> testMethod() {
        return consumerPort.testMethod();
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }
    
    @RequestMapping("/createUser")
    public PersonResponseView testPostMethod() {
        return consumerPort.testPostMethod();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
