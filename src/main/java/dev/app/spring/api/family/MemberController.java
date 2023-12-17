package dev.app.spring.api.family;

import io.micrometer.observation.annotation.Observed;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@Observed(name = "member-controller")
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

  private final MemberService memberService;

  @GetMapping
  ResponseEntity<List<Member>> getAllMembers() {
    return new ResponseEntity<>(memberService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  ResponseEntity<Member> getMemberById(@PathVariable Long id) {
    return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<Member> addMember(Member member) {
    return new ResponseEntity<>(memberService.addMember(member), HttpStatus.CREATED);
  }

  @PutMapping
  ResponseEntity<Member> updateMember(Member member) {
    return new ResponseEntity<>(memberService.updateMember(member), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteMember(@PathVariable Long id) {
    memberService.deleteMember(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
