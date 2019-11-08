package com.example.demo.domain;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
@NoArgsConstructor
@Data
@ToString
public class User {
    private Long id;
    private String name;
    private Date createDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}