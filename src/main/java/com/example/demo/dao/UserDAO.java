package com.example.demo.dao;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserRowMapper;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RestController
public class UserDAO {
    private JdbcTemplate template;
    public UserDAO(JdbcTemplate template) {
        this.template = template;
    }

    @PostMapping(path = "/createUser", consumes = "application/json", produces="application/json" )
    public void createUser(@RequestBody User user){
        String sql="Insert into User value(?,?,?)";
        template.update(sql,new Object[]{user.getId(),user.getName(),user.getCreateDate()});
    }

    @RequestMapping(method = RequestMethod.GET,path = "/User_All",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAll(){
        String sql = "SELECT id,name,create_date FROM USER";
        return template.query(sql, new UserRowMapper());
    }

    @RequestMapping(method = RequestMethod.PUT, path="/UserFind/{id}")
    public User findById(@PathVariable("id") Long id){
        String sql = "SELECT * FROM USER WHERE ID = ?";
        return template.queryForObject(sql,new Object[]{id},new UserRowMapper());
    }

    @RequestMapping(method = RequestMethod.POST, path="/UserUpdate/{id}")
    public void updateUser(@PathVariable("id") Long id,@RequestBody User user){
        String sql = "Update User Set id=?,name=?,createDate=? WHERE ID = ?";
        User newUser = new User();
        newUser.setId(id);
        newUser.setName(user.getName());
        newUser.setCreateDate(user.getCreateDate());
        template.update(sql,new Object[]{id,newUser.getName(),newUser.getCreateDate(),id});
    }

    @RequestMapping(method = RequestMethod.PUT, path="/UserDelete/{id}")
    public void Delete(@PathVariable("id") Long id ){
        String sql = "Delete FROM User WHERE ID = ?";
        template.update(sql,new Object[]{id});
    }
}