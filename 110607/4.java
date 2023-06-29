

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		Scanner input = new Scanner(System.in);


		while(true) {

			int n = input.nextInt();
			if(n==0) break;
			list.add(a(n));//(a(n));
			//System.out.println(Integer.MAX_VALUE);
		}
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));


		input.close();

	}
	static int a(int n) {
		int[] a = new int[20000002];
		a[1] = 1;
		a[2] = 2;
		
		int t = 2;
		int c = 3;
		int result = 0;
		int sum = 3;
		for(int i = 3; i < a.length; i++) {
			a[i] = t;
			sum = sum + t;
			result = i;
			
			if(i == c) {
				t++;
				c += a[t];
			}
			if(sum >= n) 
				break;

			
			
		}
		if(n == 1)
			result = 1;
		else if(n == 3 || n == 2)
			result = 2;

		//		a[i] = 1+a[i-a[a[i-1]]];

		return result;
	}

}
