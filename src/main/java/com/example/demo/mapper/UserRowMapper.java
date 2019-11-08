package com.example.demo.mapper;
import com.example.demo.domain.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId( rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setCreateDate(rs.getDate("create_date"));
        return user;
    }
}