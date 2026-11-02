package simple;

import java.util.Scanner;

public class WhileAscIntPrint {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	
	    int n = sc.nextInt();
	
	    // code here
	    int i = 0;
	    while (i <= n){
	    	//space before integers but not before 0
	        if (i > 0){
	            System.out.print(" ");
	        }
	        System.out.print(i);
	        i++;
	    }
	}
}
