package com.example.demo.dao;

import com.example.demo.domain.Blog;
import com.example.demo.mapper.BlogRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDAO {
    private JdbcTemplate template;

    public BlogDAO(JdbcTemplate template) {
        this.template = template;
    }
    public void createBlog(Blog blog){
        String sql="Insert into blog value(?,?,?)";
        template.update(sql,new Object[]{blog.getId(),blog.getAuthor(),blog.getCategory(),blog.getText(),blog.getCreateDate()});
    }

    public List<Blog> findAll(){
        String sql = "SELECT id,author,category,text,create_date FROM BLOG";
        return template.query(sql, new BlogRowMapper());
    }

    public Blog findById(Long id){
        String sql = "SELECT * FROM BLOG WHERE ID = ?";
        return template.queryForObject(sql,new Object[]{id},new BlogRowMapper());
    }

    public void updateBlog(Long id,Blog blog){
        String sql = "Update BLOG Set id=?,author=?,category=?,text=?,create_date=? WHERE ID = ?";
        Blog newBlog = new Blog();
        newBlog.setId(id);
        newBlog.setAuthor(blog.getAuthor());
        newBlog.setCategory(blog.getCategory());
        newBlog.setText(blog.getText());
        newBlog.setCreateDate(blog.getCreateDate());
        template.update(sql,new Object[]{id,newBlog.getAuthor(),newBlog.getCategory(),newBlog.getText(),newBlog.getCreateDate(),id});
    }

    public void Delete(Long id ){
        String sql = "Delete FROM BLOG WHERE ID = ?";
        template.update(sql,new Object[]{id});
    }
}
