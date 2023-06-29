import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

class Main {

	public static void upfour(BigInteger output[], int number, BigInteger two){
		
		for(int i = 4; i <= number; i++)
			output[i] = ((output[i-1].multiply(two)).add(output[i-2])).add(output[i-3]);
		
	}
	
	public static void main(String[] args) throws Exception {
	
		Scanner input = new Scanner(System.in);
		/**
		사용할 수 있는 숫자는 1, 2, 3, 4
		n=1
		1, 4  =   2개   
		n =2  
		11, 14, 41, 44 ,2  5개   (n=1)*2 +1
		n = 3
		111, 114, 141, 411, 144, 441 414 444 21 12 24 42 3  =13 개      (n=2)*2 + (n=1) +1  
		n= 4  33개     (n=3)*2 =26  이니깐 7남으니깐  n=2 + n-1        
		n=5  84개
		(n=4)*2 = 66 18 == (n=3) + (n=2)?
		 점화식은 = (n-1)*2 + (n-2) + (n-3)
		*/
		while(input.hasNextInt()){
			int number = input.nextInt();
	
			BigInteger output[] = new BigInteger[1001];
			
			BigInteger one = new BigInteger("1");
			BigInteger two = new BigInteger("2");
			
			output[1] = one.multiply(two);
			output[2] = (output[1].multiply(two)).add(one);
			output[3] = ((output[2].multiply(two)).add(output[1])).add(one);
			
			if(number >= 4)
				upfour(output, number, two);
			
			System.out.println(output[number].toString());
		}
		
		input.close();
	}
}