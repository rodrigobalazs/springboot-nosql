package com.rbalazs.socialapi.service;

import com.rbalazs.socialapi.model.Post;
import com.rbalazs.socialapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Post Service.
 *
 * @author Rodrigo Balazs
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Retrieves a list with all the Posts
     *
     * @return a list of {@link Post}
     */
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    /**
     * Retrieves a Post by the Post Title given as parameter.
     *
     * @param title the post title to retrieve
     * @return a {@link Post}
     */
    public Post getPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    /**
     * Save a new Post into the repository.
     *
     * @param post the post to save
     * @return a {@link Post} with the persisted post
     */
    public Post save(Post post) {
        postRepository.save(post);
        return post;
    }

    /**
     * Deletes a Post by the Post Title given as parameter.
     *
     * @param title the post title to delete
     */
    public void delete(String title) {
        postRepository.deleteByTitle(title);
    }
}
