package com.example.mongo.repository;

import com.example.mongo.entity.GamerEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamerRepository extends MongoRepository<GamerEntity, String> {
  public List<GamerEntity> findAllByGameKind(String gameKind, Sort sort);
  public GamerEntity findByNameAndGameKind(String name,String gameKind);
}
