package com.org.basic.palindrom;

import java.util.ArrayList;

import static com.org.basic.palindrom.CheckPalindrome.isPalindromicString;

public class PalindromicSubstring {
    public static void main(String []args){
        String s = "aaa";
//        ArrayList<String> arrayList = palindromicSubString(s);
//        System.out.println(arrayList);
        ArrayList<String> arrayList = OptimizePalindromicSubString(s);
        System.out.println(arrayList);
        System.out.println("Number of palindromic substring : " + arrayList.size());
    }
/** Time Limit extends */
    // approach for finding all palindromic substrings runs in O(n³) time complexity
    // due to:
    //O(n²) substring generation (for loops).
    //O(n) palindrome checking (isPalindromicString).

    private static ArrayList<String> palindromicSubString(String s) {
        ArrayList<String> a = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String ss = s.substring(i,j);
                if(isPalindromicString(ss)) a.add(ss);
            }
        }
        return a;
    }

/** Optimize Solution*/
    // Approach for finding all palindromic substrings runs in O(n^2) time complexity
    // Here we have to use DP to store
    static ArrayList<String> OptimizePalindromicSubString(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];
        ArrayList<String> arrayList = new ArrayList<>();
        for(int gap =0;gap<s.length();gap++){
            for(int i=0,j=gap;j<dp.length;i++,j++) {
                if (gap == 0) dp[i][j] = true;
                /*else if (gap == 1) {
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                    else dp[i][j] = false;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) dp[i][j] = true;
                    else dp[i][j] = false;
                }*/
//                else if (gap == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
//                else dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]);

                else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (gap == 1) dp[i][j] = b;
                    else dp[i][j] = (b && dp[i+1][j-1]);
                }
                if(dp[i][j]){
                    arrayList.add(s.substring(i, j+1));
                }
            }
        }
        return arrayList;
    }
}
