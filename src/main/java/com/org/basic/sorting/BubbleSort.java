package com.org.basic.sorting;

import java.util.Random;
import java.util.Scanner;

/*
		This is the first sorting algorithm
		In this algorithm we compare one element to the next element and
		after One Pass we found that the last element of our array is sorted
		and this is the greater element of that array.

		This loop is continue and our array will be sorted
		one by one from the last.

Time Complexity {

					in Best case O(n);
					in worst case O(n^2);
				}



94 87 8 33 0
*************Before sort the Array*********************
87 8 33 0 94   IN the first pass 94 come on its position Because 94 is the greatest element
8 33 0 87 94	On second pass 87 come because 87 is greater than the remaining element
8 0 33 87 94	and so on.....
0 8 33 87 94
*************After sort the Array*********************
0 8 33 87 94


*/


public class BubbleSort {
    public static void main(String []args){
//        int []arr = {94,87,8,33,0};

        int [] arr = getNewArray();
        printArray(arr);
//        long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime();
        bubbleSort(arr);
//        long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();
        printArray(arr);
        System.out.println("Total time taken : "+(endTime-startTime)+ " ns");
    }

    private static void bubbleSort(int[] arr) {
        int n= arr.length;
        boolean flag;
        for(int i=0;i<n-1;i++){
            flag = true;
            for(int j=0;j<n-1-i;j++){
                flag = false;
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
            if(flag) break;
        }
    }
    private static void swap(int[] arr, int left, int right){
        int val = arr[left];
        arr[left] = arr[right];
        arr[right] = val;
    }

    public static void printArray(int []arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] getNewArray() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of your array : ");
        int n = scan.nextInt();
        int [] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int val = rand.nextInt(100);
            arr[i] = val;
        }
        return arr;
    }

}
