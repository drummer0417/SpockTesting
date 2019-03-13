package nl.androidappfactory.member;

import java.util.HashMap;
import java.util.Map;

public class MembersRepository {

    private Map<Integer, Member> members;

    public MembersRepository() {

        members = new HashMap<>();
    }

    public Member addMember(Member member) {

        members.put(member.getId(), member);
        return members.get(member.getId());
    }

    public Member getMember(int memberId) {

        if (members.containsKey(memberId)) {
            return members.get(memberId);
        }
        return null;
    }

    public boolean exists(int memberId) {

        if (members.containsKey(memberId)) {
            return true;
        }
        return false;
    }
}
