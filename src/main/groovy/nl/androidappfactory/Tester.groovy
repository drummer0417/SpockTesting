package nl.androidappfactory

class Tester {

    public final static void main(String[] args){

        HelloGroovy helloGroovy = new HelloGroovy()
        def greeting = helloGroovy.hallootjes("hans")
        println(greeting)

    }
}
