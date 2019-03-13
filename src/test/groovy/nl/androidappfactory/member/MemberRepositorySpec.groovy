package nl.androidappfactory.member

import spock.lang.Shared
import spock.lang.Specification

class MemberRepositorySpec extends Specification {

    @Shared
    MembersRepository membersRepository = new MembersRepository();

    def "AddMember"() {

        given: "A new member"
        def member = new Member(id: 1, firstName: "Hans", lastName: "van Meurs")

        when: "a  member is added to the db"
        def newMember = membersRepository.addMember(member)

        then: "a member is added"
        newMember // is short for  newMember != null
    }

    def "GetMember"() {

        given: "A repository with a member"
        def member = new Member(id: 2, firstName: "Pietje", lastName: "Puk")
        membersRepository.addMember(member)

        when: "find a member in db"
        def retrievedMember = membersRepository.getMember(2)

        then: "a member is added"
        retrievedMember.firstName == "Pietje"
        retrievedMember.lastName == "Puk"
        retrievedMember.id == 2
    }
}
