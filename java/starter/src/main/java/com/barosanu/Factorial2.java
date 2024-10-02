package com.barosanu;

public class Factorial2 {
    
    
    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static String toUpperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String upperCaseString = input.toUpperCase();
        return upperCaseString;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
