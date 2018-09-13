package io.pivotal.microservices.pact.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsumerPort {

    private final String url;
    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerPort(@Value("${producer}") String url) {
        this.url = url;
        this.restTemplate = new RestTemplate();
    }

    public List<TestView> testMethod() {
        ParameterizedTypeReference<List<TestView>> responseType = new ParameterizedTypeReference<List<TestView>>() {};
        return this.restTemplate.exchange(this.url + "/testUrl", HttpMethod.GET, null, responseType).getBody();
    }
    
    public PersonResponseView testPostMethod() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		// MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		// converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
		// messageConverters.add(converter);
		// this.restTemplate.setMessageConverters(messageConverters);
		return this.restTemplate.postForObject(this.url + "/createUser", null, PersonResponseView.class);


    }
}
