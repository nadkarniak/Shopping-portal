package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import edu.northeastern.cs5200.daos.productDao;
import edu.northeastern.cs5200.models.Product;

@Controller
public class CreateController {


  @Autowired
  private productDao productDao;

  /*@RequestMapping(value = "/welcome")
  @ResponseBody
  public String viewHomePage(Model model) {
    List<Product> listProducts = productDao.listAll();
    model.addAttribute("listProducts", listProducts);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("welcome");
    //return modelAndView;
    return "welcome.html";
  }*/

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }


}
