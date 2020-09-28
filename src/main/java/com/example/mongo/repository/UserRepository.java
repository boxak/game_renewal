package com.example.mongo.repository;

import com.example.mongo.entity.UserEntity;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
  @Autowired
  MongoTemplate mongoTemplate;

  Logger log = LoggerFactory.getLogger(UserRepository.class);

  public UserEntity readOne(String _id) {
    UserEntity userEntity = new UserEntity();
    try {
      userEntity = mongoTemplate.findById(new ObjectId(_id), UserEntity.class);
      log.info("UserEntity :::: "+userEntity);
    } catch (Exception e) {
      log.info(e.getMessage());
    }
    return userEntity;
  }

  public boolean insert(UserEntity userEntity) {
    boolean result = false;
    try {
      mongoTemplate.insert(userEntity);
      result = true;
    } catch (Exception e) {
      log.info(e.getMessage());
    }
    return result;
  }

  public boolean update(UserEntity userEntity) {
    boolean result = false;
    try {
      Criteria criteria = new Criteria("_id");
      criteria.is(new ObjectId(userEntity.get_id()));
      Query query = new Query(criteria);
      mongoTemplate.updateFirst(query, (UpdateDefinition) userEntity,UserEntity.class);
      result = true;
    } catch (Exception e) {
      log.info(e.getMessage());
    }
    return result;
  }

  public boolean delete(String _id) {
    boolean result = false;
    try {
      Criteria criteria = new Criteria("_id");
      criteria.is(new ObjectId(_id));
      Query query = new Query(criteria);
      mongoTemplate.remove(query, UserEntity.class);
      result = true;
    } catch (Exception e) {
      log.info(e.getMessage());
    }
    return result;
  }

  public List<UserEntity> readMulti(String key, String value) {
    List<UserEntity> list = new ArrayList<>();
    System.out.println("Repository :::: "+key+" "+value);
    try {
      Query query = null;
      if(!"_id".equals(key)) {
        query = new Query(Criteria.where(key).is(value));
      } else {
        query = new Query(Criteria.where(key).is(new ObjectId(value)));
      }
      list = mongoTemplate.find(query,UserEntity.class);
    } catch (Exception e) {
      log.info(e.getMessage());
    }
    return list;
  }
}
