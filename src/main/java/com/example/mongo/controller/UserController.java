package com.example.mongo.controller;

import com.example.mongo.entity.UserEntity;
import com.example.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping(value = "/main")
  public ModelAndView goMain() {
    ModelAndView mav = new ModelAndView("main");
    return mav;
  }

  @GetMapping(value = "/readOne")
  public ModelAndView readOne(String _id) {
    ModelAndView mav = new ModelAndView("userList");
    mav.addObject("userEntity",userService.readOne(_id));
    return mav;
  }

  @PostMapping(value = "/insert")
  public ModelAndView insert(UserEntity userEntity) {
    boolean result = userService.insert(userEntity);
    ModelAndView mav = new ModelAndView("resultPage");
    mav.addObject("action","insert");
    mav.addObject("result",result);
    return mav;
  }

  @GetMapping(value = "/update")
  public ModelAndView update(UserEntity userEntity) {
    boolean result = userService.update(userEntity);
    ModelAndView mav = new ModelAndView("resultPage");
    mav.addObject("action","update");
    mav.addObject("result",result);
    return mav;
  }

  @GetMapping(value = "/delete")
  public ModelAndView delete(String _id) {
    boolean result = userService.delete(_id);
    ModelAndView mav = new ModelAndView("resultPage");
    mav.addObject("action","delete");
    mav.addObject("result",result);
    return mav;
  }

  @GetMapping(value = "/readMulti")
  public ModelAndView readMulti(String key, String value) {
    List<UserEntity> list = userService.readMulti(key, value);
    ModelAndView mav = new ModelAndView("userList");
    mav.addObject("list",list);
    return mav;
  }
}
