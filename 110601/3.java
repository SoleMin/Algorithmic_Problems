import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	
	static List<BigInteger> fibo = new ArrayList<>();
	
	public static void fibo_cal(BigInteger a, BigInteger b, BigInteger max) {
		fibo.add(a);
		if(a.compareTo(max) != 1)
			fibo_cal(b, a.add(b), max);
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger max = new BigInteger("10");
        max = max.pow(100);
        fibo_cal(new BigInteger("1"), new BigInteger("2"), max);
        
        while(true) {
        	String input = scanner.nextLine();
    		String[] temp = input.split(" ");
    		
    		if (temp[0].equals("0") && temp[1].equals("0"))
    			break;
    		
    		BigInteger a = new BigInteger(temp[0]);
    		BigInteger b = new BigInteger(temp[1]);
    		int i = 0;
				int start = 0;
    		while (fibo.get(i).compareTo(a)==-1)
    			i++;
				start = i;
    		int end = 0;
    		while (fibo.get(i).compareTo(b)!=1)
    			i++;
				end = i;
				int result = end - start;
    		System.out.println(result);
        }
	}
}