import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int a = 0; a < t; a++){
			int n = input.nextInt();
			int p = input.nextInt();
			int[] array_p = new int[p];
			for(int i = 0; i < p; i++){
				array_p[i] = input.nextInt();
			}
			int i = 0;
			int count = 0;
			int[] array_n = new int[n+1];
			while(i < p){
				for(int j = 1; j <= n; j++){
					if((j-1) % 7 < 5 && j % array_p[i] == 0)
						array_n[j]++;
				}
				i++;
			}
			for(int j = 1; j <= n; j++){
				if(array_n[j] > 0)
					count++;
			}
			System.out.println(count);
		}
		input.close();
	}
}