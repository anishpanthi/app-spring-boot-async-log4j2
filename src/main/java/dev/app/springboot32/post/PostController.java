package dev.app.springboot32.post;

import io.micrometer.observation.annotation.Observed;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@RequiredArgsConstructor
@Observed(name = "post-controller")
@ResponseBody
public class PostController {

  private final PostService postService;

  @GetMapping("/posts")
  Collection<Post> getPosts() {
    return this.postService.getPosts();
  }

  @GetMapping("/posts/{id}")
  Post getPostById(@PathVariable int id) {
    return this.postService.getPostById(id);
  }

}
