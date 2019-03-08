package nl.androidappfactory

import spock.lang.Specification

class GeenHelloStuffTest extends Specification {

    def GeenHelloStuff geenHelloStuff = new GeenHelloStuff();

    void testGetMessage() {

        given: "name: Hans"
        def name = "Hans"

        when: "getMessage is called"
        def message = geenHelloStuff.getMessage(name)

        then: "'Halootjes Hans' will be returned"
        message == "Halootjes Hans"
        "Halootjes Hansje" != message


//        expect:
//        "Halootjes Hans" == geenHelloStuff.getMessage(name)
    }
}
