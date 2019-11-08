package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class Blog {
    private Long id;
    private Long author;
    private Long category;
    private String text;
    private Date createDate;
}
