package com.rbalazs.socialapi.controller.swagger;

import com.rbalazs.socialapi.controller.PostController;
import com.rbalazs.socialapi.model.Post;
import com.rbalazs.socialapi.enums.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Swagger interface related to {@link PostController}.
 * API Documentation/Swagger at => http://<project_url>/swagger-ui/index.html
 *
 * @author Rodrigo Balazs
 */
@Tag(name = "Post API", description = "API endpoints related to Posts")
public interface PostControllerSwagger {

    @Operation(summary = "Retrieves all Posts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "returns a JSON Array with all the available Posts",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Post.class)))})})
    public ResponseEntity<List<Post>> getPosts();


    @Operation(summary = "Retrieves a Post by Title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "returns a JSON Object with the Post information",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Post.class))})})
    public ResponseEntity<Post> getPostByTitle(
            @Parameter(description = "post title", example = AppConstants.POST_BOOST_CREATIVITY, required = true)
            @PathVariable String title);


    @Operation(summary = "Saves a new Post")
    public ResponseEntity<Post> save(@RequestBody Post post);


    @Operation(summary = "Deletes a Post by Title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "returns void / nothing",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Void.class)))})})
    public ResponseEntity<Void> delete(
            @Parameter(description = "post title to delete", example = AppConstants.POST_CREATIVE_WRITING, required = true)
            @PathVariable String title);
}
