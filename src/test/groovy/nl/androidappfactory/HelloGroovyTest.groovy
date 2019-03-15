package nl.androidappfactory

import spock.lang.Specification

class HelloGroovyTest extends Specification {
    def "Hallootjes"() {

        given: "een hallozegger"
        HelloGroovy helloGroovy = new HelloGroovy();

        when: "roep de groeter voor Hans"
        def greeting = helloGroovy.hallootjes("Hans")

        then:
        greeting == "Hallo Hans"
    }
}
