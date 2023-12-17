package dev.app.spring.api.family;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author Anish Panthi
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberDao memberDao;

  @Override
  public Member getMemberById(Long id) {
    return memberDao.getMemberById(id);
  }

  @Override
  public Member addMember(Member member) {
    return memberDao.addMember(member);
  }

  @Override
  public Member updateMember(Member member) {
    return memberDao.updateMember(member);
  }

  @Override
  public void deleteMember(Long id) {
    memberDao.deleteMember(id);
  }

  @Override
  public List<Member> findAll() {
    return memberDao.findAll();
  }
}
