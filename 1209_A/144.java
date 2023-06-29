//package Round584;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int a []=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
//		System.out.println(Arrays.toString(a));
		int k=a.length;
		for(int i=a.length-1;i>=0;i--) {
			int A=a[i];
			for (int j=0;j<i;j++) {
				if(A%a[j]==0) {
					k--;
					break;
				}
			}
		}
		System.out.println(k);
		sc.close();
	}

}
