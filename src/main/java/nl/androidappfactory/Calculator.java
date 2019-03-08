package nl.androidappfactory;

public class Calculator {

    public int add(int i, int j) {

        return i + j;
    }

    public int subtrackt(int i, int j) {

        return i - j;
    }

    public int multiply(int i, int j) {

        return i * j;
    }

    public double divide(int i, int j) {

        double d1 = i;
        double d2 = j;

        if (d2 == 0) {
            throw new ArithmeticException("Division by zero not allowd!!!!");
        }
        return d1 / d2;
    }
}
