package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import edu.northeastern.cs5200.daos.productDao;
import edu.northeastern.cs5200.daos.userDao;
import edu.northeastern.cs5200.models.Buyer;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Supplier;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.UserLogin;
import edu.northeastern.cs5200.models.UserRegistration;
import edu.northeastern.cs5200.repositories.BuyerRepository;
import edu.northeastern.cs5200.repositories.SupplierRepository;

@Controller
public class CreateController {


  @Autowired
  private productDao productDao;

  @Autowired
  private userDao userDao;

  @Autowired
  private BuyerRepository buyerRepository;

  @Autowired
  private SupplierRepository supplierRepository;

  @RequestMapping("/registration")
  public String index(Model model) {
    UserRegistration user = new UserRegistration();
    model.addAttribute("user", user);
    return "index";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistration userDto) {


    if(userDto.getPassword().equals(userDto.getConfirmPassword())) {


      if(userDto.getUserType().equals("buyer")) {
        Buyer user  = new Buyer();
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        userDao.saveBuyer(user);
      }
      else  {
        Supplier user = new Supplier();
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        userDao.saveSupplier(user);
      }
      return "redirect:/login";
    }
    else {

      return "redirect:/registration";
    }
  }



  @RequestMapping("/login")
  public String login(Model model) {
    UserLogin userLogin = new UserLogin();
    model.addAttribute("login", userLogin);
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String authenticateLogin(@ModelAttribute("login") @Valid UserLogin userLogin) {

    if(userLogin.getUserType().equals("buyer")) {
      for(Buyer buyer: buyerRepository.findAll()) {
        if(buyer.getUserName().equals(userLogin.getUserName()) &&
                buyer.getPassword().equals(userLogin.getPassword())) {
          return "buyer";
        }
      }
    }
    else if(userLogin.getUserType().equals("supplier")) {
      for(Supplier supplier: supplierRepository.findAll()) {
        if(supplier.getUserName().equals(userLogin.getUserName()) &&
                supplier.getPassword().equals(userLogin.getPassword())) {
          return "supplier";
        }
      }
    }
    else {

    }

    return "redirect:/login";
  }



}
