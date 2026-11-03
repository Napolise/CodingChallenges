package arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class containsDuplicate {
	public static void main(String[] args){
		
		int[] nums = new int[] {1,2,3,1};
		

		
		//System.out.print(containDupeHaspMap(nums));
		System.out.println(containsDupeSet(nums) + ": speed Function");
		
		System.out.print(containsDupeSpace(nums) + ": space Function");
	}
	
	// Standard well done answer, but this is optimized for speed
	// see next method if space is a concern not time. 
	public static boolean containsDupeSet(int[] nums) {
		
		HashSet<Integer> numSet = new HashSet<>();
		/** 
		  slightly optimized enhanced loop
		  for (int x : nums) {
		  		.add returns a boolean if actually added
		 		if(!numSet.add(x)) {
		 			return true;
		 		}
		 	}
		 * 
		 * 
		 */
		 for (int i = 0; i < nums.length; i++) {
			 if (numSet.contains(nums[i])) {
				 //match found
				 return true;
			 } else { 
				 numSet.add(nums[i]); 
				 }
		 }
		
		//no match found
		return false;
	}
	
	/** This function sorts the array first (this DOES change the base data set, 
	which may not be acceptable in real world ENV)
	however this improves space constraints by not creating a new data 
	structure via HashSet.
	**/
	public static boolean containsDupeSpace(int[] nums) {
		
		Arrays.sort(nums);
		
		//check for duplicate neighbor after sorting array. 
		for (int i = 0; i < nums.length - 1 ; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		
		//no match found
		return false;
	}

	/**
	 * //OLD Answer //slow on large sets, by not comparing index // better to use
	 * hashSet public static boolean containDupeHaspMap(int[] nums) {
	 * 
	 * Map<Integer, Integer> dupeMap = new HashMap<>();
	 * 
	 * boolean duplicateFound = false;
	 * 
	 * for (int i = 0; i < nums.length; i++) { if (!dupeMap.containsValue(nums[i])){
	 * dupeMap.put(i, nums[i]); } else { duplicateFound = true; return
	 * duplicateFound; } }
	 * 
	 * return duplicateFound; }
	 **/
}
