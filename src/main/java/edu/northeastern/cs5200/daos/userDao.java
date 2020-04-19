package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import edu.northeastern.cs5200.modelHelpers.UserLogin;
import edu.northeastern.cs5200.models.AppManager;
import edu.northeastern.cs5200.models.Buyer;
import edu.northeastern.cs5200.models.Supplier;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.*;


@Service
@Transactional
public class userDao {

  @Autowired
  UserRepository userRepository;

  @Autowired
  BuyerRepository buyerRepository;

  @Autowired
  SupplierRepository supplierRepository;

  @Autowired
  AppManagerRepository appManagerRepository;

  @Autowired
  LoginRepository loginRepository;

  @Autowired
  ProductRepository productRepository;

  public boolean saveUser(User user) {
    userRepository.save(user);
    return true;
  }

  public boolean saveBuyer(Buyer buyer) {
    buyerRepository.save(buyer);
    return true;
  }

  public boolean saveSupplier(Supplier supplier) {
    supplierRepository.save(supplier);
    return true;
  }

  public boolean saveAppManager(AppManager appManager) {
    appManagerRepository.save(appManager);
    return true;
  }

  public List<Buyer> findAllBuy() {
    return (List<Buyer>) buyerRepository.findAll();
  }

  public List<Supplier> findAllSup() {
    return (List<Supplier>) supplierRepository.findAll();
  }


  public Map<String, String> findAllBuyers() {
    try {
      List<Buyer> buyers = (List<Buyer>) buyerRepository.findAll();
      Map<String, String> buyerMap = new HashMap<>();
      for (Buyer buyer : buyers) {
        buyerMap.put(buyer.getUserName(), buyer.getPassword());
      }

      return buyerMap;

    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Buyer findBuyerByUsername(String username){
    return buyerRepository.findBuyerByUsername(username);
  }

  public Supplier findSupplierByUsername(String username){
    return supplierRepository.findSupplierByUsername(username);
  }

  public Optional<Buyer> findBuyerById(int Id){
    return buyerRepository.findById((long)Id);
  }

  public Optional<Supplier> findSupplierById(int Id){
    return supplierRepository.findById((long)Id);
  }

  public void deleteBuyer(int id) {
    userRepository.deleteById(id);
  }

  public  void deleteSupplier(int id) {
    userRepository.deleteById(id);
  }

  //get the userLogin
  public Buyer getBuyerFromLogin(UserLogin userLogin) {
    List<Buyer> buyers = findAllBuy();
    Buyer buyerCart;
    for(Buyer buyer: buyers) {
      if(buyer.getUserName().equals(userLogin.getUserName())){
        return buyer;
      }
    }
    return null;
  }

  public void saveLoginInfo(UserLogin login) {
    loginRepository.save(login);
  }

  public UserLogin getLoginInfo() {
    List<UserLogin> loginList =  (List<UserLogin>) loginRepository.findAll();
    for(UserLogin userLogin: loginList) {
      return  userLogin;
    }
    return  null;
  }

  public void deleteLoginInfo() {
    loginRepository.deleteAll();
  }

}
