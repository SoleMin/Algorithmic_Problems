import java.io.*;
import java.util.*;
import java.util.regex.*;

public class A {
	static Scanner scan = new Scanner (System.in);
	static PrintStream out = System.out;
	
	static void go (int n) {
		if (n == 0) {
			System.out.println (0 + " " + 0 + " " + 0);
			return;
		}
		int a = 0, b = 1;
		int c = a + b; 
		while (n > c) {
			a = b;
			b = c;
			c = a + b;
		}
		System.out.println (0 + " " + a + " " + b);
	}
	
	public static void main (String[] args) {
		int n = scan.nextInt();
		go (n);
	
	} 
			
	
}
