package edu.northeastern.cs5200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.northeastern.cs5200.daos.productDao;
import edu.northeastern.cs5200.daos.userDao;
import edu.northeastern.cs5200.repositories.BuyerRepository;
import edu.northeastern.cs5200.repositories.SupplierRepository;

@Controller
public class DeleteController {

  @Autowired
  private userDao userDao;

  @Autowired
  productDao productDao;


  @RequestMapping("product/delete/{id}")
  public String deleteProduct(@PathVariable(name = "id") int id) {
    productDao.deleteProductById(id);
    return "redirect:/supplier";
  }

  @RequestMapping("buyer/delete/{userName}")
  public String deleteBuyer(@PathVariable(name = "id") int id) {
    userDao.deleteBuyer(id);
    return "redirect:/updatebuyer";
  }

  @RequestMapping("supplier/delete/{id}")
  public String deleteSupplier(@PathVariable(name = "id") int id) {
    userDao.deleteSupplier(id);
    return "redirect:/updateSupplier";
  }


}
