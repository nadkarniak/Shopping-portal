package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

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

}
