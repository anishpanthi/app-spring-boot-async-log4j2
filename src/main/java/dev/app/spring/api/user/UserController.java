package dev.app.spring.api.user;

import io.micrometer.observation.annotation.Observed;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@ResponseBody
@RequiredArgsConstructor
@Observed(name = "user-controller")
@RequestMapping("/api/users")
public class UserController {

  private final UserRepository userRepository;

  @GetMapping
  Collection<User> getUsers() {
    return this.userRepository.getUsers();
  }

}
