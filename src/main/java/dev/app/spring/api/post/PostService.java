package dev.app.spring.api.post;

import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 * @author Anish Panthi
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class PostService {

  private final RestClient restClient;

  Collection<Post> getPosts() {
    var posts =
        this.restClient.get()
            .uri("https://jsonplaceholder.typicode.com/posts")
            .retrieve()
            .body(new ParameterizedTypeReference<List<Post>>() {
            });
    assert posts != null;
    log.info("Total posts extracted: {}", posts.size());
    return posts;
  }

  Post getPostById(int id) {
    var post =
        this.restClient.get()
            .uri("https://jsonplaceholder.typicode.com/posts/{id}", id)
            .retrieve()
            .body(Post.class);
    assert post != null;
    log.info("Post extracted: {}", post);
    return post;
  }

}
