package com.example.gallenc.exceptionsandroid;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionTest {

    String[] exampleArray = {"a", "b", "c"};

    @Test
    public void testMethod() {
        System.out.println("start of test");
        try {
            for ( int i = 0; i < 3; i++) {
                System.out.println("printing array" + i);
                System.out.println(exampleArray[i]);
            }
            System.out.println("this is called if no exception occurs");
        } catch ( Exception ex) {
            System.out.println("an exception occurs");
            ex.printStackTrace();
        } finally {
            System.out.println("this is always called");
        }
        System.out.println("end of test");
    }
}
