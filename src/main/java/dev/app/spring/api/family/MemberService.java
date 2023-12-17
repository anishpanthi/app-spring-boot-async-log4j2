package dev.app.spring.api.family;

import java.util.List;

/**
 * @author Anish Panthi
 */
public interface MemberService {

  /**
   * Get member by id
   *
   * @param id - Member Id
   * @return - Member
   */
  Member getMemberById(Long id);

  /**
   * Add member
   *
   * @param member - Member
   * @return - Member
   */
  Member addMember(Member member);

  /**
   * Update member
   *
   * @param member - Member
   * @return - Member
   */
  Member updateMember(Member member);

  /**
   * Delete member
   *
   * @param id - Member Id
   */
  void deleteMember(Long id);

  /**
   * Get all members
   *
   * @return - List of members
   */
  List<Member> findAll();

}
