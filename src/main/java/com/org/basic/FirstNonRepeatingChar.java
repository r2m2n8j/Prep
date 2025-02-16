package com.org.basic;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String []args){

        String name = "Ramanuj MishRamnj";
//        char character = findFirstNonRepeatingCharacterBruteForce(name);
//        char ch = findFirstNonRepeatingCharacter(name);
//        System.out.println(ch);

        int index = findIndexOfFirstNonRepeatingCharacter(name);
        System.out.println(index);

    }

    public static int findIndexOfFirstNonRepeatingCharacter(String name){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<name.length();i++){
            if(map.containsKey(name.charAt(i))){
                map.put(name.charAt(i), -1);
            }else{
                map.put(name.charAt(i), i);
            }
        }
        System.out.println(map);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()!=-1){
                return entry.getValue();
            }
        }
        return -1;
    }

    private static char findFirstNonRepeatingCharacterBruteForce(String s){
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            boolean isUnique = true;
            for(int j=0;j<s.length();j++){
                if (i != j && ch == s.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) return ch;
        }
        return '1';
    }

    private static char findFirstNonRepeatingCharacter(String s){

        /*
//     Using of LinkedHashMap -> It maintain insertion order of character while HashMap in not maintain insertion order
        Map<Character, Integer> map = new LinkedHashMap<Character,Integer>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        for(Map.Entry<Character, Integer> e: map.entrySet()){
            if(e.getValue() ==1){
                return e.getKey();
            }
        }
        return '\0';

        */
//        Using Frequency Array of 256 because character in not in lowerOrUpper case
        int[] freqArray = new int[256];

        for(int i=0;i<s.length();i++){
            freqArray[s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++){
            if(freqArray[s.charAt(i)] == 1){
//                return i; // index of first non-repeating character
                System.out.println(s.charAt(i));
                return s.charAt(i);  //first non-repeating character
            }
        }
       return '1';  //If no non-repeating character
    }
}
