package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import edu.northeastern.cs5200.models.Feedback;
import edu.northeastern.cs5200.repositories.FeedbackRepository;

public class feedbackDao {
  @Autowired
  FeedbackRepository feedbackRepository;

  public boolean saveFeedback(Feedback feedback) {
    feedbackRepository.save(feedback);
    return true;
  }

  public List<Feedback> getAllFeedback(){
    return (List<Feedback>) feedbackRepository.findAll();
  }
}
