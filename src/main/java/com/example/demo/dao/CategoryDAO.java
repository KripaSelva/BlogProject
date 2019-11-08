package com.example.demo.dao;

import com.example.demo.domain.Category;
import com.example.demo.mapper.CategoryRowMapper;
import com.example.demo.mapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAO {
    private JdbcTemplate template;

    public CategoryDAO(JdbcTemplate template) {
        this.template = template;
    }

    public void createCategory(Category category){
        String sql="Insert into Category value(?,?,?)";
        template.update(sql,new Object[]{category.getId(),category.getName(),category.getDescription()});
    }

    public List<Category> findAll(){
        String sql = "SELECT id,name,description FROM CATEGORY";
        return template.query(sql, new CategoryRowMapper());
    }

    public Category findById(Long id){
        String sql = "SELECT * FROM CATEGORY WHERE ID = ?";
        return template.queryForObject(sql,new Object[]{id},new CategoryRowMapper());
    }

    public void updateCategory(Long id,Category category){
        String sql = "Update Category Set id=?,name=?,description=? WHERE ID = ?";
        Category newCategory = new Category();
        newCategory.setId(id);
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        template.update(sql,new Object[]{id,newCategory.getName(),newCategory.getDescription(),id});
    }

    public void Delete(Long id ){
        String sql = "Delete FROM Category WHERE ID = ?";
        template.update(sql,new Object[]{id});
    }
}
