package dev.app.spring.api.family;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@Observed(name = "member-controller")
@RequiredArgsConstructor
public class MemberController {

}
