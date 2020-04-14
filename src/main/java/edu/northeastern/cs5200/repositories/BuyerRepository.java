package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Buyer;

public interface BuyerRepository extends CrudRepository<Buyer, Long> {

  @Modifying
  @Query("delete from User b where b.userName=:userName")
  void deleteBuyers(@Param("userName") String title);


  @Query("SELECT buyer FROM Buyer buyer WHERE buyer.userName = :username ")
  public Buyer findBuyerByUsername(@Param("username") String userName);
}


