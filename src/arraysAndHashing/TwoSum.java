/**
Given an array arr[] and an integer target, return the pair of elements whose
sum equals target. An element cannot be used twice unless it appears multiple
times in the array.
Note:  If no pair exist, return an empty array.

https://www.geeksforgeeks.org/problems/2-sum-find-a-pair-with-given-sum/1


 */
package arraysAndHashing;

import java.util.*;

public class TwoSum {
	public List<Integer> twoSum(int arr[], int target) {
		
		//visited numbers | key = the number | value = key's index in array
        Map<Integer, Integer> arrayMap = new HashMap<>();

        //loop through the array
		for (int i = 0; i < arr.length; i++) {
			//the num we need to sum up to the target
			int complement = target - arr[i];
			//does the map have our complement?
			if (arrayMap.containsKey(complement)) {
				//return array list with complement and found number
				return new ArrayList<>(Arrays.asList(complement, arr[i]));
			}
			//complement not found, store the results in the arrayMap
			arrayMap.put(arr[i], i);
		}
		//no match found in whole array, return an empty array
		return new ArrayList<>();
	}
}

/**
 * Brute Force solution, i don't like it for time complexity and is unfinished
 * doesnt handle no duplicates 
        // code here
        
    	int a; //hold element to add
        int sum;
        List<Integer> targetList = new ArrayList<>();
        
        for(a = 0; a < arr.length; a++) {
        	//a loop
        	for (int b = 0; b < arr.length; b++) {
        		sum = arr[a] + arr[b];
        		if (sum == target) {
        			targetList.add(0, arr[a]);
        			targetList.add(1, arr[b]);
        		}//end if
        	}//end b loop
        }//end a loop
        
    	//clear return error for now
    	return targetList; 
 */
