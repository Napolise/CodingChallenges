package arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? 
How would you adapt your solution to such a case?
 */
public class validAnagram {
	public static void main(String[] args) {
		//test cases will go here.
		//test abba and baba for duplicate letters
		//test leetcode examples as well
		
		System.out.println("Test 1 | True         : " + isAnagram("car", "rac"));
		System.out.println("Test 2 | False        : " + isAnagram("car", "rat"));
		System.out.println("Test 3 | True(dupes)  : " + isAnagram("abba", "baba"));
		System.out.println("Test 4 | False(dupes) : " + isAnagram("acca", "baba"));
		System.out.println("Test 5 | False(dupes) : " + isAnagram("aab", "abb"));
	}
	
	/**
	 * @param s - string one for compare
	 * @param t - string 2 for compare
	 * @return - true or false if anagram
	 */
	public static boolean isAnagram(String s, String t) {
		//base size check, if not equal then not anagram.
		//constraints say checking for empty string not needed
		if (s.length() != t.length()) {
			return false;
		}
		
		//lower case alphabet array
		int[] charArray = new int[26];
		
		//populate charArray elements with character counts from string 1
		for (char ch : s.toCharArray()) {
			//each instance of a character from the string is converted to
			//its place in alphabet then increments that element by 1.
			charArray[(int)(ch - 'a')] += 1; 
		}
		
		//loop to decrement the alphabet array if, negative number is reached
		//then the strings were not anagrams, as t had more of a letter than s.
		for (char ch : t.toCharArray()) {
			if (--charArray[ch - 'a'] < 0) {
				return false;
			}
		}
		
		/** this array depop loop is needed for below greyed out anagram 
		 * check methods
		//depopulate charArray based on string 2
		for (char ch : t.toCharArray()) {
			//each instance of a character from the string is converted to
			//its place in alphabet then decrements that element by 1.
			charArray[(int)(ch - 'a')] -= 1; 
		}
		*/
		
		/** 
		 * This is a better loop to check for 0s in the array than the below
		 * stream method, just easier to understand, but still not optimal
		//loop through array, if an element is not 0 then break and return
		//false as the strings were not equal anagrams
		for (int count : charArray) {
			if (count != 0) {
				return false;
			}
		}
		//return true;
		*/
		
		/**
		 * clunky stream check for all zeros in array.
		//if all arrays are empty then the strings were anagrams
		if (Arrays.stream(charArray).allMatch(num -> num == 0)) {
			return true;
		}
		*/
		//default return, strings were anagrams
		return true;
	}
	/**
	 * This method is for working outside of the lowercase alphabet constraint
	 * the original challenge applies. 
	 * While this code was commented by an AI tool the code was written by me.
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagramUnicode(String s, String t) {
	    // Quick exit: anagrams are rearrangements of the same characters, so their
	    // UTF-16 lengths must match. (This stays valid for Unicode: both strings
	    // contain the same code points, so they take up the same number of chars.)
	    if (s.length() != t.length()) {
	        return false;
	    }

	    // One map for both strings: key = code point, value = how many more times
	    // s has it than t has seen so far.
	    // We key on Integer code points, NOT Character, because Java's char is only
	    // 16 bits. Characters outside the basic range (many emoji) are stored as TWO
	    // chars (a surrogate pair), and counting chars would split one character in half.
	    Map<Integer, Integer> counts = new HashMap<>();

	    // Pass 1: count up for every code point in s.
	    // codePoints() walks the string one real character at a time, joining
	    // surrogate pairs back into a single int.
	    for (int cp : s.codePoints().toArray()) {
	        counts.put(cp, counts.getOrDefault(cp, 0) + 1);
	    }

	    // Pass 2: count down for every code point in t.
	    for (int cp : t.codePoints().toArray()) {
	        int current = counts.getOrDefault(cp, 0);

	        // t has this character more times than s did (or s never had it),
	        // so the strings cannot be anagrams.
	        if (current == 0) {
	            return false;
	        }

	        if (current == 1) {
	            // Count hits zero: remove the entry so the map only holds
	            // characters that are still unmatched.
	            counts.remove(cp);
	        } else {
	            counts.put(cp, current - 1);
	        }
	    }

	    // Same lengths + t never used a character more than s had it means every
	    // count was matched exactly, so the map should be empty.
	    return counts.isEmpty();
	}
	
	/**
	 * Old attempt, learned about hashCode not being good here. 
	 * corrected, is now O(n) time.
	 * @param s - string one for compare
	 * @param t - string 2 for compare
	 * @return - true or false if anagram
	 */
	public static boolean isAnagram2(String s, String t) {
		//base size check, if not equal then not anagram.
		if (s.length() != t.length()) {
			return false;
		}
		
		//first string map
		HashMap<Character, Integer> sMap = new HashMap<>();
		//second string map
		HashMap<Character, Integer> tMap = new HashMap<>();
		
		//I suspect this is not counting duplicate letters correctly
		//build character hashMap from string s
		for (Character ch : s.toCharArray()) {
			//add character, or increment value if already present
			sMap.put(ch, sMap.getOrDefault(ch, 0) + 1); 
		}
		//build char hashMap from string t
		for (Character ch : t.toCharArray()) {
			//use merge to accomplish same as the put for sMap.
			tMap.merge(ch, 1, Integer::sum); 
		}
		
		//debug statement, found accidentally mapping sMap twice.
		//System.out.println("has code for s is: " + sMap.hashCode());
		//System.out.println("has code for t is: " + tMap.hashCode());
		
		//compare maps
		if (sMap.equals(tMap)) {
			return true;
		}
		
		//hashCode was not the same, therefore no anagram, return false
		return false;
	}
	
	//Solution from leetCode with 0ms time.
	//is essentially my submission but loops are optimized to one loop
	class Solution {
	    static {
	        for (int i = 0; i < 444; i++) {
	            isAnagram("a", "");
	        }
	    }
	    public static boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()) return false;
	        int[] data = new int[26];
	        for ( int i = 0; i < s.length(); i++ ) {
	            data[s.charAt(i) - 'a']++;
	            data[t.charAt(i) - 'a']--;
	        }
	        for (int value: data) {
	            if (value != 0) return false;
	        }
	        return true;
	    }
	}

}
