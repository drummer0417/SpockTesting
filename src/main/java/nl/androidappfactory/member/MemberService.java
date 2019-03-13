package nl.androidappfactory.member;

public class MemberService {


    MembersRepository membersRepository;

    public MemberService(MembersRepository membersRepository) {

        this.membersRepository = membersRepository;
    }

    public Member addMember(Member member) {

        if (!membersRepository.exists(member.getId())) {
            return membersRepository.addMember(member);
        } else {
            throw new IllegalArgumentException("Member already exists");
        }
    }

    public Member getMember(int id){

        return membersRepository.getMember(id);
    }
}
