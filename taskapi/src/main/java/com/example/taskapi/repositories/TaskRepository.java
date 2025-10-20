package com.example.taskapi.repositories;

import com.example.taskapi.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    Optional<Task> findById(String id);
    List<Task> findByNameContainingIgnoreCase(String name);
}