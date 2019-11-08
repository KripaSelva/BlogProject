package com.example.demo.domain;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
public class ToDo {
    /*
   "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
     */
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}