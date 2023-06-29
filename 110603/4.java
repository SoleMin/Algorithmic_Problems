import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	static List<BigInteger> list = new ArrayList<>();
	
	public static void calculate() {
		while(list.size()<=1000) {
			int index = list.size();
			BigInteger sum = list.get(index-1).multiply(new BigInteger("2"));
			sum = sum.add(list.get(index-2));
			sum = sum.add(list.get(index-3));
			list.add(sum);
		}
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        list.add(new BigInteger("0"));
        list.add(new BigInteger("2"));
        list.add(new BigInteger("5"));
        list.add(new BigInteger("13"));
        calculate();
        
        while(scanner.hasNext()) {
        	String input = scanner.nextLine();
        	int sum = Integer.parseInt(input);
        	System.out.println(list.get(sum));
        }
	}
}