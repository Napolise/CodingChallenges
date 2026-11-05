package arraysAndHashing;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of strings strs, group all anagrams together into sublists. 
 * You may return the output in any order.
 * An anagram is a string that contains the exact same characters as another 
 * string, but the order of the characters can be different.
 * 
 * Constraints:
    1 <= strs.length <= 10000.
    0 <= strs[i].length <= 100
    strs[i] is made up of lowercase English letters.
 */
public class groupAnagrams {
	public static void main(String[] args) {
		
		String[] strs = {"act","pots","tops","cat","stop","hat"};
		
		System.out.println(groupAnagrams(strs));
		
	}
	
	public static List<List<String>> groupAnagrams(String[] strs){
		//Hashmap of strings
		HashMap<String, List<String>> results = new HashMap<>();
		
		//alphabet array, elements is frequency of character in string
		
		
		
		//iterate through strs array
		for (String str : strs) {
			int[] count = new int[26];
			
			//iterate through each str in strs to build count array for each
			for (char ch : str.toCharArray()) {
				count[ch - 'a'] += 1;
			}//end ch loop
			
			//turn count into a string for map key comparisons
			String key = Arrays.toString(count);
			//lambda function to make new keys if not present, 
			//then add value to key, if it is present. 
			/**
			 * computeIfAbsent returns ArrayList<> in this instance
			 * if key 'k' does not exist (our count array turned string)
			 * then '->' make a new ArrayList
			 * '->' think when given x then do thing
			 * in our instance when given k make array list or add to it.
			 * .add(str) adds our word to this new arraylist
			 * if k does exist -> return the existing Array then
			 * .add(str) to that array list. 
			 * 
			 */
		    results.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
			
		}//end str loop

		//return list of anagrams
		return new ArrayList<>(results.values());
		
	}

}
