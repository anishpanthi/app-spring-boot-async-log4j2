package dev.app.spring.api.family;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

/**
 * @author Anish Panthi
 */
@HttpExchange(url = "/api")
public interface MemberClient {

  /**
   * Get member by id
   *
   * @param id - Member Id
   * @return - Member
   */
  @GetExchange("/member/{id}")
  Member getMemberById(@PathVariable Long id);

  /**
   * Add member
   *
   * @param member - Member
   * @return - Member
   */
  @PostExchange("/member")
  Member addMember(@RequestBody Member member);

  /**
   * Update member
   *
   * @param member - Member
   * @return - Member
   */
  @PutExchange("/member")
  Member updateMember(@RequestBody Member member);

  /**
   * Delete member
   *
   * @param id - Member Id
   */
  @DeleteExchange("/member/{id}")
  ResponseEntity<Void> deleteMember(@PathVariable Long id);

  /**
   * Get all members
   *
   * @return - List of members
   */
  @GetExchange("/members")
  List<Member> findAll();

}
