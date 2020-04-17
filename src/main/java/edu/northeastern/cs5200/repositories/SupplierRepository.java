package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import edu.northeastern.cs5200.models.Supplier;

@Service
@Transactional
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

  @Query("DELETE from Supplier supplier WHERE supplier.id =: id")
  public void deleteSupplier(@Param("id") int id);

  @Query("SELECT supplier FROM Supplier supplier WHERE supplier.userName = :username ")
  public Supplier findSupplierByUsername(@Param("username") String userName);
}
