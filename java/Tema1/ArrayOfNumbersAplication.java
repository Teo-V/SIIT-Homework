package Homework_1;

import java.util.HashMap;

//Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

public class ArrayOfNumbersAplication {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(hash.containsKey(arr[i])){
                hash.put(arr[i],hash.get(arr[i])+1);
            }else{
                hash.put(arr[i],1);
            }
        }
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length-1;j++){
                if(arr[i]!=arr[j] && hash.get(arr[i])==hash.get(arr[j])){
                    return false;
                }
            }
        }
        return true;
    }
}

