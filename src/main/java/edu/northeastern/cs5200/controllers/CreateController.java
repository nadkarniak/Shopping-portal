package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import edu.northeastern.cs5200.daos.productDao;
import edu.northeastern.cs5200.daos.userDao;
import edu.northeastern.cs5200.models.AppManager;
import edu.northeastern.cs5200.models.Buyer;
import edu.northeastern.cs5200.models.Coupon;
import edu.northeastern.cs5200.models.DeleteUser;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Supplier;
import edu.northeastern.cs5200.modelHelpers.UserLogin;
import edu.northeastern.cs5200.modelHelpers.UserRegistration;
import edu.northeastern.cs5200.repositories.AppManagerRepository;
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

  @Autowired
  private AppManagerRepository appManagerRepository;


  @RequestMapping("/login/buyer")
  public String buyerPage(Model model) {
     List<Product> listProducts = productDao.listAll();
     model.addAttribute("listProducts", listProducts);
     return "buyer";
  }


  @RequestMapping("/login/manager/coupon")
  public String couponCreation(Model model) {
    Coupon coupon = new Coupon();
    model.addAttribute("coupon", coupon);
    return  "newCoupon";
  }

  @RequestMapping(value = "/login/manager/coupon", method = RequestMethod.POST)
  public String couponSave(@ModelAttribute("coupon") @Valid Coupon coupon) {
    productDao.saveCoupon(coupon);
    return  "redirect:/login/manager";
  }

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

  @RequestMapping("/login/manager")
  public String loginManager(Model model) {
    model.addAttribute("coupon", new Coupon());
    return "manager";
  }

  @RequestMapping(value = "/login/manager", method = RequestMethod.POST)
  public String addCoupon(@ModelAttribute("coupon") @Valid Coupon coupon) {
    productDao.saveCoupon(coupon);
    return "redirect:/login/manager";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String authenticateLogin(@ModelAttribute("login") @Valid UserLogin userLogin) {

    if(userLogin.getUserType().equals("buyer")) {
      for(Buyer buyer: buyerRepository.findAll()) {
        if(buyer.getUserName().equals(userLogin.getUserName()) &&
                buyer.getPassword().equals(userLogin.getPassword())) {
          return "redirect:/login/buyer";
        }
      }
    }
    else if(userLogin.getUserType().equals("supplier")) {
      for(Supplier supplier: supplierRepository.findAll()) {
        if(supplier.getUserName().equals(userLogin.getUserName()) &&
                supplier.getPassword().equals(userLogin.getPassword())) {
          return "redirect:/supplier";
        }
      }
    }
    else if(userLogin.getUserType().equals("appManager")) {
      for(AppManager appManager: appManagerRepository.findAll()) {
        if(appManager.getUsername().equals(userLogin.getUserName()) &&
                appManager.getPassword().equals(userLogin.getPassword())) {
          return "redirect:/login/manager";
        }
      }
    }

    return "redirect:/login";
  }

  @RequestMapping("/supplier")
  public String viewHomePage(Model model) {
    List<Product> listProducts = productDao.listAll();
    model.addAttribute("listProducts", listProducts);
    return "product";
  }

  @RequestMapping("new/product")
  public String addNewProduct(Model model) {
    model.addAttribute("product", new Product());
    return "newProduct";
  }

  @RequestMapping(value = "new/product", method = RequestMethod.POST)
  public String addNewProductInTable(@ModelAttribute("product") @Valid Product product) {
    productDao.saveProduct(product);
    return "newProduct";
  }



  @RequestMapping("product/edit/{id}")
  public String editProduct(@PathVariable(name = "id") int id) {
    productDao.deleteProductById(id);
    return "redirect:/new/product";
  }

  @RequestMapping("back/supplier")
  public String backToSupplier() {
      return "redirect:/supplier";
  }




  @RequestMapping("/updateBuyer")
  public String updateBuyer(Model model) {
    DeleteUser deleteUser = new DeleteUser();
    List<Buyer> buyerList = userDao.findAllBuy();
    model.addAttribute("listBuyers", buyerList);
    return "updatebuyer";
  }

  @RequestMapping("/updateSupplier")
  public String updateSupplier(Model model) {
    List<Supplier> supplierList = userDao.findAllSup();
    model.addAttribute("listSuppliers", supplierList);
    return "updateSupplier";
  }


}
