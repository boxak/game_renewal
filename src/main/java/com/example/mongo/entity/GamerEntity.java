package com.example.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "ScoreInfo")
public class GamerEntity {
  private String name;
  private int score;
  private String gameKind;
}
