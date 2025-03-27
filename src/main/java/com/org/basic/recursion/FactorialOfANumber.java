package com.org.basic.recursion;

public class FactorialOfANumber {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(factorial(0));
    }
    public static int factorial(int n){
        // 5 = 5*factorial(4);
        if(n<=1) return 1;
        return n * factorial(n-1);
    }
}
