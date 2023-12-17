package dev.app.spring.api.family;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

/**
 * @author Anish Panthi
 */
@Repository
@Log4j2
@RequiredArgsConstructor
public class MemberDao {

  private final JdbcClient jdbcClient;

  public Member getMemberById(Long id) {
    return jdbcClient.sql(
            "SELECT id,type,full_name,words,updated_name,updated_date_time FROM member WHERE id = :id")
        .param("id", id)
        .query(Member.class)
        .single();
  }

  public Member addMember(Member member) {
    int update = jdbcClient.sql(
            "INSERT INTO member(id,type,full_name,words,updated_name,updated_date_time) values(?,?,?,?,?,?)")
        .params(List.of(member.id(), member.type(), member.fullName(), member.words(),
            member.updatedName(), member.updatedOn()))
        .update();
    if (update == 1) {
      log.info("Member added successfully");
      return member;
    }
    throw new RuntimeException("Member not added");
  }

  public Member updateMember(Member member) {
    var updated = jdbcClient.sql(
            "update member set type = ?, full_name = ?, words = ?, updated_name = ?, updated_date_time = ? where id = ?")
        .params(List.of(member.type(), member.fullName(), member.words(),
            member.updatedName(), member.updatedOn(), member.id()))
        .update();
    if (updated == 1) {
      log.info("Member updated successfully");
      return member;
    }
    throw new RuntimeException("Member not updated");
  }

  public void deleteMember(Long id) {
    var updated = jdbcClient.sql("delete from member where id = :id")
        .param("id", id)
        .update();
    if (updated == 1) {
      log.info("Member deleted successfully");
    }
    throw new RuntimeException("Member not deleted");
  }

  public List<Member> findAll() {
    return jdbcClient.sql(
            "SELECT id,type,full_name,words,updated_name,updated_date_time FROM member")
        .query(Member.class)
        .list();
  }
}
