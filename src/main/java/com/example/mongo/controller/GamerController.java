package com.example.mongo.controller;

import com.example.mongo.entity.GamerEntity;
import com.example.mongo.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GamerController {

  @Autowired
  private GamerService gamerService;

  @RequestMapping("/{game}")
  public String getGame(@PathVariable String game, HttpSession session) {
    //session.setAttribute("gameKind",game);

    return game+"game";
  }

  @ResponseBody
  @RequestMapping(value="/insertScore",produces="application/json; charset=UTF-8")
  public String insertScore(@ModelAttribute GamerEntity entity) {
    boolean result = gamerService.insert(entity);
    String msg = "";
    if(result) msg = "점수가 입력되었습니다.";
    else msg = "오류가 발생했습니다!";
    return msg;
  }

  @RequestMapping("/rankingBoard")
  public ModelAndView listAll(String gameKind) {
    List<GamerEntity> gamerList = gamerService.findAllByGameKind(gameKind);
    ModelAndView mav = new ModelAndView();
    mav.addObject("gameKind",gameKind);
    mav.addObject("gamerList",gamerList);
    mav.setViewName("rankingBoard");
    return mav;
  }
}
