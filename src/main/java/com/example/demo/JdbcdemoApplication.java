package com.example.demo;
import com.example.demo.dao.BlogDAO;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.domain.Blog;
import com.example.demo.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class JdbcdemoApplication{
    private UserDAO userDAO;
    private CategoryDAO categoryDAO;
    private BlogDAO blogDAO;
    private UserValidationService service;

    private User newUser = new User();
    public void setNewUser(long id, String name, Date date){
        newUser.setId(id);
        newUser.setName(name);
        newUser.setCreateDate(date);
    }

    public JdbcdemoApplication(UserDAO userDAO, CategoryDAO categoryDAO, BlogDAO blogDAO, UserValidationService service) {
        this.userDAO = userDAO;
        this.categoryDAO = categoryDAO;
        this.blogDAO = blogDAO;
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcdemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        //setNewUser(5,"olaf", new Date());
        return args -> {
            //userDAO.createUser(newUser);
            //System.out.println("----------User Table--------------");
            //userDAO.findAll().forEach(System.out::println);
            //System.out.println(userDAO.findById((long) 1));
            //System.out.println("-----------Category Table-------------");
            //categoryDAO.findAll().forEach(System.out::println);
            //System.out.println("----------Blog Table--------------");
            //blogDAO.findAll().forEach(System.out::println);
            //service.validateEmail("selvakripa@gmail.com");
            System.out.println(service.getTodo());
        };
    }
}