package nl.androidappfactory

import spock.lang.FailsWith
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorTest extends Specification {

    Calculator calculator;

    def "Add"() {

        given: "a brand new calculator"
        calculator = new Calculator()

        when:
        def sum = calculator.add(8, 7)

        then:
        sum == 15

    }

    @Unroll("multiply: #expect arg1: #arg1 arg2 #arg2")
    def "multiply"() {

        given: "a brand new calculator"
        calculator = new Calculator()

        expect:
        expect == calculator.multiply(arg1, arg2)

        where:
        expect << [10, 100, 102, 200]
        arg1 << [5, 20, 51, 20]
        arg2 << [2, 5, 2, 10]
    }

    @Unroll("subtrackt: #arg1 - #arg2 = #result")
    def "subtrackt"() {

        given: "a brand new calculator"
        calculator = new Calculator()

        expect: "result of subtracktion"
        result == calculator.subtrackt(arg1, arg2)

        where: "values are"
        result | arg1  | arg2
        12     | 20    | 8
        18     | val() | 2
        122    | 200   | 78
        193    | 200   | 7
        167    | 200   | 33
        122    | 10000 | 9878
    }

    def val() {
        return 20
    }

    @FailsWith(ArithmeticException)
    def "division by zero"() {
        given: "a calculator"
        calculator = new Calculator()

        expect:
        def result = calculator.divide(10, 0)
    }

    @Unroll("divide: #arg1 / #arg2 = #result")
    def "divide"() {

        given: "a brand new calculator"
        calculator = new Calculator()

        expect: "result of subtracktion"
        result == calculator.divide(arg1, arg2)

        where: "values are"
        result | arg1 | arg2
        2.5    | 20   | 8
        1.25   | 10   | 8
        500    | 1000 | 2
    }
}
