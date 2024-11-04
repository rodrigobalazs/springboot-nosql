package com.rbalazs.socialapi.controller;

import com.rbalazs.socialapi.controller.swagger.PostControllerSwagger;
import com.rbalazs.socialapi.model.Post;
import com.rbalazs.socialapi.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Post REST Controller.
 * API Documentation/Swagger at => http://<project_url>/swagger-ui/index.html
 */
@RestController
@RequestMapping("/post")
public class PostController implements PostControllerSwagger {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getPosts")
    public ResponseEntity<List<Post>> getPosts() {
        LOGGER.info("starts to execute postController.getPosts()");
        List<Post> posts = postService.getPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Post> getPostByTitle(@PathVariable String title) {
        LOGGER.info("starts to execute postController.getPostByTitle() with title:{}" , title);
        Post post = postService.getPostByTitle(title);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post) {
        LOGGER.info("starts to execute postController.save()");
        Post persistedPost = postService.save(post);
        return new ResponseEntity<>(persistedPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/title/{title}")
    public ResponseEntity<Void> delete(@PathVariable String title) {
        LOGGER.info("starts to execute postController.delete() with title:{}" , title);
        postService.delete(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

