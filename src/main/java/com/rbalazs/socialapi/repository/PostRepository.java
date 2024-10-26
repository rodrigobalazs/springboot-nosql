package com.rbalazs.socialapi.repository;

import com.rbalazs.socialapi.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
    Post findByTitle(String name);
    void deleteByTitle(String name);
}
