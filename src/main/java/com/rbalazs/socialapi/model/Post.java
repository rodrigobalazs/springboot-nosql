package com.rbalazs.socialapi.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.Validate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a given Post.
 *
 * @author Rodrigo Balazs
 */
@Document(collection = "posts")
@Getter
@Setter
public class Post {

    @Id
    private String id;
    private String title;
    private String content;

    /** Empty Constructor required by Spring Data MongoDB. */
    public Post() {}

    /**
     * Creates a new Post.
     *
     * @param theTitle the post title, cannot be null nor empty.
     * @param theContent the post content, cannot be null nor empty.
     */
    public Post(final String theTitle, final String theContent) {
        Validate.notEmpty(theTitle, "The post title cannot be null nor empty");
        Validate.notEmpty(theContent, "The post content content be null nor empty");
        title = theTitle;
        content = theContent;
    }
}