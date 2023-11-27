package dev.app.springboot32.user;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

/**
 * @author Anish Panthi
 */
@Repository
@RequiredArgsConstructor
@Log4j2
public class UserRepository {

  private final JdbcClient jdbcClient;

  private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(rs.getInt("id"),
      rs.getString("full_name"), rs.getString("email"));

  Collection<User> getUsers() {
    Collection<User> users = this.jdbcClient.sql("select * from user_tbl").query(this.userRowMapper)
        .list();
    log.info("Total users: {}", users.size());
    return users;
  }
}
