package com.nick.blog.concepts;

public class FunctionalProgramming {
    public static void main(String... args) {

/*
        SomeClassT objT = new SomeClassT();
        objT.method01("Nick");

        SomeOtherClass sObjT = new SomeOtherClass();
        sObjT.someOtherMethod(objT, "Nick");
*/

        SomeOtherClass sObjT = new SomeOtherClass();
        sObjT.someOtherMethod(new Interface01() {
            @Override
            public void method01(String name) {
                System.out.println("Hello, " + name + "!");
            }
        }, "Nick");


/*
        SomeClassF objF = new SomeClassF();
        Interface02 inter = s -> System.out.println("Hello, " + s + "!");
        objF.method01(inter, "Nick");

        inter = (String s) -> {System.out.println("Hello, " + s + "!");};
        objF.method01(inter, "Nick");
*/
    }

    static class SomeClassT implements Interface01 {
        public void method01(String name){
            System.out.println("Hello, " + name + "!");
        }
    }

    static class SomeOtherClass {
        public void someOtherMethod(Interface01 inter, String name){
            inter.method01(name);
        }
    }

    static class SomeClassF {
        public void method01(Interface01 inter, String name){
            inter.method01(name);
        }
    }

    @FunctionalInterface
    interface Interface01 {
        void method01(String name);
    }

    @FunctionalInterface
    interface Interface02 extends Interface01 {
        default void method02(String name){
            System.out.print("Name=");
            printName(name);
        }
        static void printName(String name){
            System.out.println(name);
        }
    }
}
