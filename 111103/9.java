import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		int e[][] = new int[1000][2];
		int index[] = new int[1000];
		int n = 0;

		while(input.hasNextLine()) {
			e[n][0] = input.nextInt();
			e[n][1] = input.nextInt();
			index[n] = n + 1;
			n++;
			input.nextLine();
		}

		int temp;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(e[i][0] > e[j][0]) {
					temp = e[j][0];
					e[j][0] = e[i][0];
					e[i][0] = temp;
					temp = e[j][1];
					e[j][1] = e[i][1];
					e[i][1] = temp;
					temp = index[j];
					index[j] = index[i];
					index[i] = temp;
				}
			}
		}
		
		int count = 0;
		int max = 0;
		for(int i = 0; i < n; i++) {
			count = 0;
			for(int j = i + 1; j < n; j++) {
				if(e[i][0] < e[j][0] && e[i][1] > e[j][1]) {
					count++;
				}
			}
			if(count > max)
				max = count;
		}
		
		System.out.println(max);
		
		for(int i = 0; i < n; i++) {
			System.out.println(index[i] + " " + e[i][0] + " " + e[i][1]);
		}

		input.close();
	}
}