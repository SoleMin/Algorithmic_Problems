import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		
		
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> input = new ArrayList<>();
		
		BigInteger[] gu = new BigInteger[1000];
		
		while(sc.hasNextLine()){
			input.add(sc.nextInt());
			sc.nextLine();
		}
		
		int number = 0;
		while(number < input.size()){
		
			BigInteger two = new BigInteger("2");
			BigInteger five = new BigInteger("5");
			BigInteger thirteen = new BigInteger("13");
			
			gu[0] = BigInteger.ZERO;
			gu[1] = two;
			gu[2] = five;
			gu[3] = thirteen;
			
			for(int i=4; i<1000; i++){
				
				BigInteger n1, n2, n3;
				n1 = gu[i-1].multiply(two);
				n2 = gu[i-2];
				n3 = gu[i-3];
				
				gu[i] = n3.add(n1.add(n2));
				
				
				// gu[i] = gu[i-3].add( 
				// 	gu[i-2].add( 
				// 		gu[i-1].multiply(two)
				// 							)
				// 										);
			}
			
			System.out.println( gu[input.get(number)] );
			number ++;
		}
		
		
	}
	
}