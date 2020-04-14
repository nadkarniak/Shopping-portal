package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import edu.northeastern.cs5200.models.Buyer;
import edu.northeastern.cs5200.models.Payment;
import edu.northeastern.cs5200.repositories.PaymentRepository;

public class paymentDao {
  @Autowired
  PaymentRepository paymentRepository;

  public boolean savePayment(Payment payment) {
    paymentRepository.save(payment);
    return true;
  }

  public List<Payment> findAllPayments(){
    return (List<Payment>) paymentRepository.findAll();
  }

}
