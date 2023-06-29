import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int t = input.nextInt();
		
		while(true) {
			if(t == 0)
				break;
			
			int n = input.nextInt();
			int p = input.nextInt();
			
			int temp[] = new int[n * p];
			int party[] = new int[p];
			
			for(int i = 0; i < p; i++)
				party[i] = input.nextInt();
			
			int k = 0;
			
			for(int i = 0; i < p; i++) {
				for(int j = party[i]; j <= n; j += party[i]) {
					if((j - 1) % 7 < 5) {
						temp[k] = j;
						k++;
					}
				}
			}
			
			int temp2[] = new int[k];
			
			for(int i = 0; i < k; i++)
				temp2[i] = temp[i];
			
			Arrays.sort(temp2);
			
			int count = k;
			
			for(int i = 0; i < k; i++)
				for(int j = i + 1; j < k; j++)
					if(temp2[i] == temp2[j]) {
						count--;
						break;
					}
			System.out.println(count);
			
			t--;
			
		}
		input.close();
	}
}