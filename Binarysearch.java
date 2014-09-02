package binarysearch;

import java.util.Arrays;
import java.util.Random;

public class Binarysearch {
    
    public static int binarySearchRec(int[] arr, int from, int to, int key){
        int mid = (from + to) / 2;
            if(to < from){
                 return -1;
            }
            if(key==arr[mid]){
                 return mid;
             }
             if(key<arr[mid]){
                 return binarySearchRec(arr, from, mid - 1, key);
            }
            else{
               return binarySearchRec(arr, mid + 1, to, key);
            }
}
    
    public static int binarySearchIter(int[] arr, int from, int to, int key){
    while (from <= to){
            int mid = (from + to) / 2;
            if(arr[mid] == key){
                 return mid; 
            }
            else if (arr[mid] < key){
                from = mid + 1;
            }
            else {        
            to = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] search = new int[100];
        Random randoms = new Random();
        for(int i = 0; i < search.length; i++){
            search[i] = randoms.nextInt(500);
        }
        
        System.out.println("Array: ");
        Arrays.sort(search);
        for(int i = 0; i < search.length; i++){
            System.out.print(search[i]+", ");
        }
        
        Integer[] keys = new Integer[20];
        System.out.println("\nKeys: ");
        for(int i = 0; i < keys.length; i++){
            keys[i] = randoms.nextInt(500);
            System.out.print(keys[i]+", ");
        }
        System.out.println("\nIterative Results:");
        for(int i=0; i < keys.length-1; i++){
        System.out.print(binarySearchIter(search,0, 
                search.length, keys[i])+", ");
        }
        System.out.println("\nRecursive Results:");
        for(int i=0; i < keys.length-1; i++){
        System.out.print(binarySearchRec(search,0, 
                 search.length, keys[i])+", ");
        }
    }
}
