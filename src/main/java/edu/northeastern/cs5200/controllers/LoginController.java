package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import edu.northeastern.cs5200.daos.userDao;

@Controller
public class LoginController {

  @Autowired
  private userDao userDao;


}
