package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.daos.userDao;
import edu.northeastern.cs5200.models.User;

@RestController
@CrossOrigin()
public class CreateController {

  @Autowired
  userDao userDao;

  @RequestMapping("/new")
  public String showNewProductPage(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "index";
  }

  @PostMapping("/signUp/patient")
  @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
  public Boolean createPatient(@RequestBody User user) {
    return userDao.saveUser(user);
  }


}
