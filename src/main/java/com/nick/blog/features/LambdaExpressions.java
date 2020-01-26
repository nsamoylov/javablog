package com.nick.blog.features;

public class LambdaExpressions {

    public static void main(String... args){
        double d = someMethod(new FirstExampleImpl(), 2.0);
        System.out.println(d);   //prints: 10.0

        //double
                d = someMethod(x -> x + 2, 2.0);
        System.out.println(d);   //prints: 10.0
    }

    private static double someMethod(FirstExample fe, double d){
        int x = fe.addTwo(3);
        return d * x;
    }

    private static class FirstExampleImpl implements FirstExample {
        public int addTwo(int n){
            return n + 2;
        }
    }

    interface FirstExample {
        int addTwo(int n);
    }
}
