package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import edu.northeastern.cs5200.daos.productDao;
import edu.northeastern.cs5200.models.Product;

@RestController
public class CreateController {


  @Autowired
  private productDao productDao;

  @GetMapping("/")
  public List<Product> viewHomePage(Model model) {
    List<Product> listProducts = productDao.listAll();
    return listProducts;
    //model.addAttribute("listProducts", listProducts);
    //return "product";
  }


}
