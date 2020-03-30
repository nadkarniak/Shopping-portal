package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
}
