import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] present = new int[3000];
		int curr, prev, diff, n;
		while(input.hasNextLine()){
			n = input.nextInt();
			String s = "Jolly";
			for(int i = 0; i < n; i++){
				present[i] = 0;
			}
			prev = input.nextInt(); 
			for(int i = 1; i < n; i++){
				curr = input.nextInt();
				diff = curr - prev;
				if(diff < 0)
					diff = -diff;
				if(diff <= 0 || diff >= n || present[diff] == 1){
					s = "Not jolly";
					break;
				}
				present[diff] = 1;
				prev = curr;
			}
			System.out.println(s);
			input.nextLine();
		}
		input.close();
	}
}