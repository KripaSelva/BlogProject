package com.example.demo;
import com.example.demo.domain.EmailResponse;
import com.example.demo.domain.ToDo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class UserValidationService {
    private RestTemplate restTemplate;
    public UserValidationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public boolean validateEmail(String email){
        EmailResponse obj = restTemplate.getForObject("http://localhost:3000/email", EmailResponse.class);
        System.out.println(obj);
        return obj.isValid();
    }
    public ToDo getTodo(){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/{id}",ToDo.class,2);
    }
}