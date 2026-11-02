package dynamicProg;

import java.util.*;

public class StairClimb {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter num stairs: ");
		
		int numStairs = scan.nextInt();
		
		int answer = countWays(numStairs);
		
		scan.close();
		
		System.out.println(answer);
	}
	
	public static int countWays(int n) {
		//base cases 1 and 2
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		//non base cases
		int oneStep =1;
		int twoStep = 1;
		
		//loop to find number of steps
		for (int i = 2; i <= n; i++) {
			int temp = oneStep;
			oneStep = oneStep + twoStep;
			twoStep = temp;
		}
		
		return oneStep;
		
	}
}
