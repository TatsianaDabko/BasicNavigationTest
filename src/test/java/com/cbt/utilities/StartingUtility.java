package com.cbt.utilities;

public class StartingUtility {

    public static void verifyEquals (String expected, String actual){

        if(expected.equals(actual)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }
}
