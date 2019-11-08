package com.example.demo.mapper;

import com.example.demo.domain.Blog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogRowMapper implements RowMapper<Blog> {
    @Override
    public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
        Blog blog = new Blog();
        blog.setId(rs.getLong("id"));
        blog.setAuthor(rs.getLong("author"));
        blog.setCategory(rs.getLong("category"));
        blog.setText(rs.getString("text"));
        blog.setCreateDate(rs.getDate("create_date"));
        return blog;
    }
}
