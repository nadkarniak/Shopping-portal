package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;

public class userDao {

  @Autowired
  UserRepository userRepository;

  public boolean saveUser(User user) {
    userRepository.save(user);
    return true;
  }

}
