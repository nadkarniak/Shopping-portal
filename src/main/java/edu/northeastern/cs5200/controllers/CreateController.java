package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.northeastern.cs5200.daos.productDao;
import edu.northeastern.cs5200.daos.userDao;
import edu.northeastern.cs5200.models.Buyer;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Supplier;
import edu.northeastern.cs5200.models.User;

@Controller
public class CreateController {


  @Autowired
  private productDao productDao;

  @Autowired
  private userDao userDao;

  @RequestMapping("/")
  public String index(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "index";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/new")
  public String showNewProductPage(Model model) {
    Product product = new Product();
    model.addAttribute("product", product);

    return "p";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveProduct(@ModelAttribute("product") Product product) {
    userDao.saveProduct(product);
    return "redirect:/new";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String saveBuyer(@ModelAttribute("user") User user, @RequestParam(name = "type") String userName) {


    if(userName.equals("supplier")) {
      userDao.saveUser(user);
    }
    return "redirect:/login";
  }

  @RequestMapping(value = "/signUp/buyer", method = RequestMethod.POST)
  public String saveProduct(@ModelAttribute("user") Buyer buyer) {
    userDao.saveBuyer(buyer);
    return "redirect:/login";
  }


  /*@PostMapping("/signUp/buyer")
  public Boolean createPatient(@RequestBody Buyer buyer) {
    return userDao.saveBuyer(buyer);
  }


  @PostMapping("/signUp/supplier")
  public Boolean createDoctor(@RequestBody Supplier supplier) {
    return userDao.saveSupplier(supplier);
  }*/




}
