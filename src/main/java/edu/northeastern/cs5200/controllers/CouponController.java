package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import edu.northeastern.cs5200.daos.productDao;
import edu.northeastern.cs5200.daos.userDao;
import edu.northeastern.cs5200.modelHelpers.UserLogin;
import edu.northeastern.cs5200.models.Coupon;

@Controller
public class CouponController {

  @Autowired
  private userDao userDao;

  @Autowired
  private productDao productDao;




}
