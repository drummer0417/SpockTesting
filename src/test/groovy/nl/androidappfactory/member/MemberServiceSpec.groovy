package nl.androidappfactory.member

import org.junit.internal.runners.statements.Fail
import spock.lang.FailsWith
import spock.lang.Shared
import spock.lang.Specification

class MemberServiceSpec extends Specification {


    def "Add new member"() {
        given: "a new (nonexisting) member"
        def newMember = new Member(id: 1, firstName: "Hans")
        def membersRepository = Mock(MembersRepository)
        def memberService = new MemberService(membersRepository)

        when: "add member"
        membersRepository.exists(1) >> false
        membersRepository.addMember(newMember) >> newMember
        def addedMember = memberService.addMember(newMember)

        then: "member is added"
        addedMember == newMember
    }

    //FailsWith(IllegalArgumentException)
    def "Add already existing member"() {
        given: "an existing member"
        def existingMember = new Member(id: 1, firstName: "Hans")

        and: "a service and a repo"
        def membersRepository = Mock(MembersRepository)
        def memberService = new MemberService(membersRepository)

        when: "add member"
        membersRepository.exists(1) >> true
        memberService.addMember(existingMember)

        then: "Exception is thrown"
        IllegalArgumentException e = thrown()
        e.getMessage() == "Member already exists"
    }

    def "retrieve an existing member"() {

        given: "a member id"
        def memberId = 1

        and: "a service and a repo"
        def membersRepository = Mock(MembersRepository)
        def memberService = new MemberService(membersRepository)

        when: "retrieve nonexisting member"
        membersRepository.getMember(memberId) >> null
        def retrievedMember = memberService.getMember(memberId)

        then: "null will be returned"
        !retrievedMember
    }
}