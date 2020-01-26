package com.nick.blog.concepts;

import java.util.Random;

public class Exceptions {
    public static void main(String... args) {

        catchRuntimeException();
        dontCatchRuntimeException();
        catchException();
        try{
            throwsException();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        catchParticularProblemException();
        catchRuntimeExceptionWithMessage();

    }

    private static void catchRuntimeException(){
        try{
            m1(42);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private static void dontCatchRuntimeException(){
        m1(42);
    }

    private static void m1(int i){
        throw new RuntimeException();
    }

    private static void catchException(){
        try{
            m2(42);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void throwsException() throws Exception{
        m2(42);
    }

    private static void m2(int i) throws Exception{
        throw new Exception();
    }

    static class Problem1Exception extends Exception {}
    static class Problem2Exception extends Exception {}

    private static void m3(int i) throws Problem1Exception, Problem2Exception{
        if(i > 0){
            throw new Problem1Exception();
        } else if(i > 0){
            throw new Problem2Exception();
        }
        // do what has to be done
    }

    private static void catchParticularProblemException(){
        Random random = new Random();
        int i = random.nextInt();
        try{
            m3(i);
        } catch (Problem1Exception ex){
            //do something to address Problem1
        } catch (Problem2Exception ex){
            //do something to address Problem2
        }
    }

    private static void m4(int i) {
        if(i > 0){
            throw new RuntimeException("Problem1");
        } else if(i > 0){
            throw new RuntimeException("Problem2");
        }
        // do what has to be done
    }

    private static void catchRuntimeExceptionWithMessage(){
        Random random = new Random();
        int i = random.nextInt();
        try{
            m4(i);
        } catch (RuntimeException ex){
            if("Problem1".equals(ex.getMessage())){
                //do something to address Problem1
            } else if("Problem2".equals(ex.getMessage())){
                //do something to address Problem2
            } else {
                throw new RuntimeException("Unexpected problem: " + ex.getMessage());
            }
        }
    }

    private static void avoidException(){
        Random random = new Random();
        int i = random.nextInt();
        if(i != 0){
            // do something to correct the problem or
            throw new RuntimeException("Invalid input value = " + i);
        }
        m4(i);
    }
}
