package com.rbalazs.socialapi.service;

import com.rbalazs.socialapi.enums.AppConstants;
import com.rbalazs.socialapi.model.Post;
import com.rbalazs.socialapi.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.CollectionUtils;

/**
 * Populates the NoSQL database with sample data related to Posts in case the Post collection(a.k.a table) is empty.
 *
 * @author Rodrigo Balazs
 */
@Service
public class PopulateSampleDataService implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopulateSampleDataService.class);

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        if (CollectionUtils.isNotEmpty(postRepository.findAll())){
            return;
        }

        LOGGER.info("populates the NoSQL database with some initial sample data with Posts ..");
        createPost(AppConstants.POST_BOOST_CREATIVITY, AppConstants.POST_BOOST_CREATIVITY_CONTENT);
        createPost(AppConstants.POST_CREATIVE_WRITING, AppConstants.POST_CREATIVE_WRITING_CONTENT);
    }

    private Post createPost(String postTitle, String postContent){
        Post post = new Post(postTitle, postContent);
        return postRepository.save(post);
    }
}