package repositories;

import models.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void addMember(Member member);
    void removeMember(Member member);
    Optional<Member> findMemberById(int id);
    List<Member> getAllMembers();
}