package com.org.basic.palindrom;

/*
* A string is called a palindrome string if the reverse of
* that string is the same as the original string. For example, radar, level, etc.

 * A number that is equal to the reverse of that same number is called a palindrome number.
  For example, 3553, 12321, etc.
  *
 * */


public class CheckPalindrome {
    public static void main(String []args){
//        String s = "radr";
//        System.out.println(isPalindromicString(s));

        int number = 12321;
        System.out.println(isPalindromicNumber(number));
    }

    private static boolean isPalindromicNumber(int number){
        int num = number;
        int reverseNumber = 0;
        while (number>0){
            int rem = number%10;
            number/=10;
            reverseNumber*=10;
            reverseNumber+=rem;
        }
        System.out.println("num : "+ num + ", reverseNumber : "+ reverseNumber);
        return num == reverseNumber;
    }

    static boolean isPalindromicString(String s){
        // O(n) time and O(1) space
        int i=0, j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
