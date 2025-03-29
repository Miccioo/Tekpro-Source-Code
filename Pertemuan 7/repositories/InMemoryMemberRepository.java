package repositories;

import models.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryMemberRepository implements MemberRepository {
    private List<Member> members = new ArrayList<>();

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public void removeMember(Member member) {
        members.remove(member);
    }

    @Override
    public Optional<Member> findMemberById(int id) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst();
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }
}