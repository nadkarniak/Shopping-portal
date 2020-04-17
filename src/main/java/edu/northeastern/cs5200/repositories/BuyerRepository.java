package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import edu.northeastern.cs5200.models.Buyer;

@Service
@Transactional
public interface BuyerRepository extends CrudRepository<Buyer, Long> {

  @Modifying
  @Query("delete from User b where b.userName=:userName")
  public void deleteBuyers(@Param("userName") String title);


  @Query("SELECT buyer FROM Buyer buyer WHERE buyer.userName = :userName ")
  public Buyer findBuyerByUsername(@Param("userName") String userName);
}


