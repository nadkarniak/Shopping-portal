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

    String d1 = "2020-10-10";
    Date date = Date.valueOf(d1);

    Product product1 = new Product("a", "b",date, date, 20);
    Product product2 = new Product("b", "c", date, date, 30);

    productDao.saveProduct(product1);
    productDao.saveProduct(product2);

  }
}