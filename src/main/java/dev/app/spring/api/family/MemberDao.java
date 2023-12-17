package dev.app.spring.api.family;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

/**
 * @author Anish Panthi
 */
@Component
@Log4j2
@RequiredArgsConstructor
public class MemberDao {

  private final JdbcClient jdbcClient;

  public Member getMemberById(int id) {
    jdbcClient.sql("select * from member_tbl where id = ?");
    return null;
  }

  public Member addMember(Member member) {
    return null;
  }

  public Member updateMember(Member member) {
    return null;
  }

  public void deleteMember(int id) {

  }

  public List<Member> findAll() {
    return null;
  }

}
