package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.models.Payment;
import edu.northeastern.cs5200.repositories.PaymentRepository;

public class paymentDao {
  @Autowired
  PaymentRepository paymentRepository;

  public boolean savePayment(Payment payment) {
    paymentRepository.save(payment);
    return true;
  }
}
