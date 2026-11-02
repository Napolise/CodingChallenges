package arraysAndHashing;

import java.util.ArrayList;

public class FindMaxSubArrayLoop {
	//private static int array[] = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    //private static int array[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	
	public static void main(String[] args) {
    	// new array lists to track current and final max sub arrays
    	ArrayList<Integer> tempMaxArray = new ArrayList<>();
    	ArrayList<Integer> finalMaxArray = new ArrayList<>();

        int array[] = new int[20];
        for(int i = 0; i < 20; ++i) {
            array[i] = (int)(Math.random() * 20 - 10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
    
        int max = 0, sum = 0;

        max = array[0]; // max holds the MAX value of subarray
        sum = array[0];
        
        // start with the first elements in the array
    	finalMaxArray.add(array[0]);
    	tempMaxArray.add(array[0]);

        for(int i = 1; i < array.length; ++i) {

            if(sum + array[i] >= array[i]) {
                sum += array[i];
                //add to new temp array
                tempMaxArray.add(array[i]);

            }
            else {
                sum = array[i];
                
                //starting new sub array
                tempMaxArray.clear();
                tempMaxArray.add(array[i]);
            }
            
            //update the final max sub array with current best max sub array
            if (sum > max) {
    			max = Math.max(sum, max);
    			finalMaxArray.clear();
    			finalMaxArray.addAll(tempMaxArray);
            }
        }


        System.out.println(max);
        System.out.println("Max sub array found was " + 
        finalMaxArray.toString() + " with a total of " + 
        		sumArrayList(finalMaxArray));
    }
    
    // function that helped me find out i need to start the max array with 
    //element 0
    public static int sumArrayList(ArrayList<Integer> list) {
    	int sum = 0;
        for (int i = 0; i < list.size(); ++i) {
        	sum += list.get(i);
        }
    	
    	return sum;
    	
    }


}
