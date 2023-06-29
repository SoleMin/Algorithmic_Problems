import java.util.*;
import java.io.*;

public class cf166a {
	private static boolean[][] matrix;
	private static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// long l = sc.nextLong();
		// int i = sc.nextInt();
		// String input = sc.nextLine();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] p = new int[n];
		int[] t = new int[n];
		int[] score = new int[n];
		for(int i=0;i<n;i++){
			p[i] = sc.nextInt();
			t[i] = sc.nextInt();
			score[i] = p[i] * 100 + (50 - t[i]);
		}
		boolean[] called = new boolean[n];
		int x = 0;
		boolean check = false;
		while(true){
			int max = 0;
			int y = 0;
			for(int i=0;i<n;i++){
				if(called[i]==false&&score[i]>max){max=score[i];}
			}
			for(int i=0;i<n;i++){
				if(max==score[i]){
					called[i] = true;
					x++;
					y++;
					if(x==k){check=true;}
				}
			}
			if(check){
				System.out.println(y);
				break;
			}
		}
	}
}

