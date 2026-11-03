package stacks;
import java.util.Map;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack; //could be removed for legacy brute force attempt

/** 
 * prompt:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

 

Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

 */

public class validParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("test 1 should be true:  " + isValid("()") );
		System.out.println("test 1 should be true:  " + isValid("()[]{}") );
		System.out.println("test 1 should be false: " + isValid("(]") );
		System.out.println("test 1 should be true:  " + isValid("([])") );
		System.out.println("test 1 should be false: " + isValid("([)]") );
		System.out.println("test 1 should be false: " + isValid("))") );
		
		System.out.println("test 2 should be true:  " + isValidStack("()") );
		System.out.println("test 2 should be true:  " + isValidStack("()[]{}") );
		System.out.println("test 2 should be false: " + isValidStack("(]") );
		System.out.println("test 2 should be true:  " + isValidStack("([])") );
		System.out.println("test 2 should be false: " + isValidStack("([)]") );
		System.out.println("test 2 should be false: " + isValidStack("))") );

	}//end main
	
	public static boolean isValid(String s) {
		//base case odd string, can't be valid
		if ( s.length() % 2 != 0) {
			return false;
		}

		//Deque for string
		Deque<Character> stack = new ArrayDeque<>();

		//map to compare characters
		Map<Character, Character> pairs = Map.of(
				')', '(',
				'}', '{',
				']', '['); 

		for ( int i = 0; i < s.length(); i++) {
			//temp variable for cleaner code holds current character in string
			Character curChar = s.charAt(i);
			//if open character then push to stack
			if (curChar.equals('(') || curChar.equals('{') || curChar.equals('[')) {
				stack.push(curChar);
			}//end if
			//if matching closer character than pop stack
			//check if empty, then peek at stack and compare string element to map
			else if (!stack.isEmpty() && stack.peek().equals(pairs.get(curChar))){
				stack.pop();
			}//end else if
			else {
				// if the stack is empty or close has no open return false
					return false;
			}//end else
		} //end for loop
		return stack.isEmpty();
	}// end function
	
	/**
	 * Stack is legacy and should not be used unless working with
	 * older code database
	 * it is however, faster by like 2-3 ms
	 */
	public static boolean isValidStack(String s) {	
		Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                char top;
                if(stack.isEmpty()){
                    return false;
                }else{
                    top=stack.pop();
                }
                if(ch=='}' && top!='{'){
                    return false;
                }
                if(ch==')' && top!='('){
                    return false;
                }
                if(ch==']' && top!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
	}//end isValid

}//end class
