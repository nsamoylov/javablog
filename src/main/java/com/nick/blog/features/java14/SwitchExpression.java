package com.nick.blog.features.java14;

public class SwitchExpression {
    public static void main(String... args){
        System.out.print("1: ");
        switchExpression1(TWO);            //prints: 1

        System.out.print("\n2: ");
        switchExpression1(FOUR);           //prints: 2

        System.out.print("\n3: ");
        switchExpression1("blah"); //prints: 3

        System.out.print("\n4: ");
        switchExpression2(Num.TWO);        //prints: 1

        System.out.print("\n5: ");
        switchExpression2(Num.FOUR);       //prints: 2

        //switchExpression2("blah"); //does not compile

        System.out.print("\n6: ");
        switchExpression3(Num.TWO);        //prints: 1

        System.out.print("\n7: ");
        switchExpression3(Num.THREE);      //prints: 5
    }

    private static final String ONE = "one", TWO = "two", THREE = "three", FOUR = "four", FIVE = "five";
    private static void switchExpression1(String number){
        var res = switch(number) {
            case ONE, TWO -> 1;
            case THREE, FOUR, FIVE -> 2;
            default -> 3;
        };
        System.out.print(res);
    }

    private enum Num { ONE, TWO, THREE, FOUR, FIVE }
    private static void switchExpression2(Num number){
        var res = switch(number) {
            case ONE, TWO -> 1;
            case THREE, FOUR, FIVE -> 2;
        };
        System.out.print(res);
    }

    private static void switchExpression3(Num number){
        var res = switch(number) {
            case ONE, TWO -> 1;
            case THREE, FOUR, FIVE -> {
                String s = number.name();
                yield s.length();
            }
        };
        System.out.print(res);
    }
}
