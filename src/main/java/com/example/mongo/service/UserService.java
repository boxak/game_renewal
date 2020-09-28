package com.example.mongo.service;

import com.example.mongo.entity.UserEntity;
import com.example.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public UserEntity readOne(String _id) {
    return userRepository.readOne(_id);
  }
  public boolean insert(UserEntity userEntity) {
    return userRepository.insert(userEntity);
  }

  public boolean update(UserEntity userEntity) {
    return userRepository.update(userEntity);
  }

  public boolean delete(String _id) {
    return userRepository.delete(_id);
  }

  public List<UserEntity> readMulti(String key, String value) {
    System.out.println(key+" "+value);
    return userRepository.readMulti(key, value);
  }
}
