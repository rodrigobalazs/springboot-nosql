package com.rbalazs.socialapi.service;

import com.rbalazs.socialapi.model.Post;
import com.rbalazs.socialapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Post Service.
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public Post save(Post post) {
        postRepository.save(post);
        return post;
    }

    public void delete(String title) {
        postRepository.deleteByTitle(title);
    }
}
