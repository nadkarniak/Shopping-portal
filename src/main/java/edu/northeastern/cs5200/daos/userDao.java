package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import edu.northeastern.cs5200.models.Buyer;
import edu.northeastern.cs5200.models.Product;
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

  public List<User> findAllBuyers() {
    return (List<User>) userRepository.findAll();
  }

  public boolean saveProduct(Product product) {
    productRepository.save(product);
    return true;
  }

}
