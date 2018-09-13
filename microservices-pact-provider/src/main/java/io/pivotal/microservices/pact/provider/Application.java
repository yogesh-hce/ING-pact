package io.pivotal.microservices.pact.provider;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/testUrl", method = RequestMethod.GET)
    public ResponseEntity<List<TestViewProvider>> testMethod() {
        return new ResponseEntity<>(Arrays.asList(new TestViewProvider(42), new TestViewProvider(100)), HttpStatus.OK);
    }
    
    
   
	@RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<PersonResponseView> testPostMethod() {
    	
        return new ResponseEntity<>(new PersonResponseView(42), HttpStatus.OK);
    }
    
}
