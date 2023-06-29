
import java.io.*;
import java.util.Scanner;
public class Test {
	public static int digit(long number){
		int i = 1;
		long exp = 1;
		while(number > i * 9 * exp){
			number -= i * 9 * exp;
			i++;
			exp *= 10;
		}
		return i;
	}
	public static int result(long number){
		int digit = digit(number);
		long exp = 1;
		for(int i = 0; i < (digit - 1); i++){
			number -= (i+1) * 9 * exp;
			exp *= 10;
		}
		long b = number / digit;
		int c = (int)(number % digit);
		if(c > 0){
			String d = Long.toString(exp + b);
			return d.charAt(c - 1) - '0';
		}
		else{
			String d = Long.toString(exp + b - 1);
			return d.charAt(d.length() - 1) - '0';
		}

	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long k = input.nextLong();
		System.out.println(result(k));
	}
}



