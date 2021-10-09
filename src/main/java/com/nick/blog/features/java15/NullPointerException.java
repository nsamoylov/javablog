package com.nick.blog.features.java15;

public class NullPointerException {
    public static void main(String... args){
        System.out.print("1:\n");
        SomeClass someClass = new SomeClass(new MyClass01(null));
        someClass.getSomeName();
    }

    private static class SomeClass {
        private MyClass01 myClass01;

        public SomeClass(MyClass01 myClass01) {
            this.myClass01 = myClass01;
        }

        public String getSomeName() { return this.myClass01.getMyClass02Object().getSomeName(); };
    }

    private static class MyClass01 {
        private MyClass02 myClass02;

        public MyClass01(MyClass02 myClass02) {
            this.myClass02 = myClass02;
        }

        public MyClass02 getMyClass02Object() { return this.myClass02; };
    }

    private static class MyClass02 {
        private String someName;

        public MyClass02(String someName) {
            this.someName = someName;
        }

        public String getSomeName() { return this.someName; }
    }
}
