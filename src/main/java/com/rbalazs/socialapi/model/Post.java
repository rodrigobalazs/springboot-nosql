package com.rbalazs.socialapi.model;

import lombok.Getter;
import lombok.Setter;
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
}