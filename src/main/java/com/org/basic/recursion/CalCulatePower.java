package com.org.basic.recursion;

public class CalCulatePower {
    public static void main(String[] args) {
        System.out.println(calculatePower(2,3));
    }
    public static int calculatePower(int x, int n){
        if(n<=0) return 1;
        return x * calculatePower(x, n-1);
    }
}
