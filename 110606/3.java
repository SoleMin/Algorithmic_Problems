import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Main {
	static List<BigInteger> hanoi = new ArrayList<>();

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
		  hanoi.add(new BigInteger("0"));
		  hanoi.add(new BigInteger("1"));
		 
		  while(scanner.hasNext()) {
	        	String input = scanner.nextLine();
	        	int n = Integer.parseInt(input);
	        	int k = 1;
	        	for (int i=2; i<=10000;) {
	        		BigInteger newhanoi = new BigInteger("1");
	        		BigInteger squard = (new BigInteger("2")).pow(k);
	        		newhanoi = newhanoi.multiply(squard);
	        		for (int j=0; j<k+1 && i<=10000; j++) {
	        			hanoi.add(hanoi.get(i-1).add(newhanoi));
	        			i++;
	        		}
	        		k++;
	        	}
	        	System.out.println(hanoi.get(n));
	        }
	}
}