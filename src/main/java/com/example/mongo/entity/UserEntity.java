package com.example.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "UserInfo")
public class UserEntity {
  @Id
  private String _id;
  private String name;
  private int age;
  private int height;
}
