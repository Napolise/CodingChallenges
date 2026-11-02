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
		
        Map<Integer, Integer> arrayMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];

			if (arrayMap.containsKey(complement)) {
				return new ArrayList<>(Arrays.asList(complement, arr[i]));
			}
			arrayMap.put(arr[i], i);
		}

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
