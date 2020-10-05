package com.example.mongo.service;

import com.example.mongo.entity.GamerEntity;
import com.example.mongo.repository.GamerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GamerService {
  @Autowired
  private GamerRepository gamerRepository;

  Logger log = LoggerFactory.getLogger(GamerService.class);

  public String insert(GamerEntity entityFromBrowser) {
    String msg = "";
    GamerEntity entityFromDB = null;
    try {
      entityFromDB = gamerRepository.findByNameAndGameKind(entityFromBrowser.getName(),entityFromBrowser.getGameKind());
      if(entityFromDB == null) {
        gamerRepository.insert(entityFromBrowser);
      } else{
        if(entityFromDB.getScore()<entityFromBrowser.getScore()) {
          gamerRepository.save(entityFromBrowser);
        }
      }
      msg = "점수가 입력되었습니다.";
    } catch(Exception e) {
      msg = "오류가 발생했습니다!";
      log.info(e.getMessage());
    }
    return msg;
  }

  public List<GamerEntity> findAllByGameKind(String gameKind) {
    List<GamerEntity> gamerList = new ArrayList<>();
    gamerList = gamerRepository.findAllByGameKind(gameKind, Sort.by(Sort.Direction.DESC,"score"));
    return gamerList;
  }

}
