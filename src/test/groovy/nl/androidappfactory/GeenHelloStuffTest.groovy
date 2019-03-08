package nl.androidappfactory

class GeenHelloStuffTest extends GroovyTestCase {

    def GeenHelloStuff geenHelloStuff;

    void setUp() {
        geenHelloStuff = new GeenHelloStuff()
    }

    void tearDown() {

    }

    void testGetMessage() {

        given: "name: Hans"
        def name = "Hans"

        when: "getMessage is called"
        def message = geenHelloStuff.getMessage(name)

        then: "'Halootjes Hans' will be returned"
        assertEquals("Hello Hansje", message)

    }
}
