package com.org.basic.stringconcept;

public class SubStringAndSubSequence {
    public static void main(String []args){

        String s = "Ramanuj";
        getAllSubString(s);
    }
    static void getAllSubString(String s){
        int count = 0;
        int n = s.length();
        for(int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<s.length();j++){
                sb.append(s.charAt(j));
                count++;
                System.out.print(sb + " , ");
            }
            System.out.println();
        }
        System.out.println(" Total Number of substring of length "+ n +" string "+ count);
    }
}
