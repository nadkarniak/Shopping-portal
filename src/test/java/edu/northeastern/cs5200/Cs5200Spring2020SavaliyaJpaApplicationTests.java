package edu.northeastern.cs5200;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.Date;
import java.util.List;

import edu.northeastern.cs5200.daos.productDao;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cs5200Spring2020SavaliyaJpaApplicationTests {

  @Test
  public void contextLoads() {
  }

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private productDao productDao;

  @Test
  public void test1() {

    /*String d1 = "2020-10-10";
    Date date = Date.valueOf(d1);

    Product product1 = new Product("Mobile", "apple generation iphone 10", date, date, 800);
    Product product2 = new Product("Garlic", "garlic paste for cooking purpose", date, date, 5);
    Product product3 = new Product("Chips", "chips lays", date, date, 2);
    Product product4 = new Product("Trimmer", "Trimmer for shaving", date, date, 50);

    productDao.saveProduct(product1);
    productDao.saveProduct(product2);
    productDao.saveProduct(product3);
    productDao.saveProduct(product4);*/

  }
}