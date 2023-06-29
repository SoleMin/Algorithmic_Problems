import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int [] f = new int[10000000 + 1];
		f[1] = 1;
		for (int i = 2; i <= 10000000; i++) {
			f[i] = 1 + f[i - f[f[i-1]]];
		}
		
		while (true){
			int n = sc.nextInt();
			if (n == 0) break;
			System.out.println(f[n]);
		}
	}
}