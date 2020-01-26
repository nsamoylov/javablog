package com.nick.blog.terms;

public class HideVsOverride {
    public static void main(String... args) {

        //instanceHideFieldOverrideMethod();
        staticHideFieldOverrideMethod();
    }

    private static void staticHideFieldOverrideMethod(){

        C c = new D();
        System.out.println(c.name);       //Class C
        System.out.println(c.getName());  //Class C

        System.out.println(((D) c).name); //Class D
    }

    private static void instanceHideFieldOverrideMethod(){

        A a = new B();
        System.out.println(a.name);      //Class A
        System.out.println(a.getName()); //Class B

        System.out.println(((B) a).name); //Class B
    }

    static class A {
        public String name = "Class A";
        public String getName(){
            return this.name;
        }
    }
    static class B extends A {
        public String name = "Class B";
        public String getName(){
            return this.name;
        }
    }

    static class C {
        public static String name = "Class C";
        public static String getName(){
            return name;
        }
    }
    static class D extends C {
        public static String name = "Class D";
        public static String getName(){
            return name;
        }
    }
}
