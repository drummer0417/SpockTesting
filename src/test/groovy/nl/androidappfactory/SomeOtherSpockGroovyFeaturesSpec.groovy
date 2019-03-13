package nl.androidappfactory

import com.thoughtworks.qdox.model.annotation.AnnotationUnsignedShiftRight
import spock.lang.Specification
import spock.lang.Unroll

class SomeOtherSpockGroovyFeaturesSpec extends Specification {

    def "Update value of map entry"() {

        given: "map with entry 'test'"
        def map = [:]
        map.test = "Initial value"

        when: "change value of test to 'updated value"
        map.test = "updated value"

        then: "value is changed"
        old(map.test) == "Initial value"
        map.test == "updated value"
        old(map.test) != map.test
    }

    def "Add items to list with overwritten left shift parameter"(){

        given: "an empty list"
        def List<String> list = []

        when: "adding 4 items to the list"
        list.add("een");
        list << "twee" << "drie" << "vier"

        then: "list is not empty"
        !list.empty
        and: "the list contains 4 items"
        list.size() == 4
        and: "the first item has value 'een'"
        list.first() == "een"
    }
}
