

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(new InputStreamReader(System.in));
		int n = s.nextInt();	
		int [] ar = new int[n];
		for (int i = 0; i < n ; i++) {
			ar[i] = s.nextInt();
	 	}
		if(ar.length == 1){
			System.out.println("NO");
		}else{
			Arrays.sort(ar);
			int num = ar[0];
			boolean flag = false;
			for (int i = 1; i < ar.length; i++) {
				if(ar[i]!= num){
					System.out.println(ar[i]);
					flag = true;
					break;
				}
			}
			if(!flag)
				System.out.println("NO");
		}

	}

}
