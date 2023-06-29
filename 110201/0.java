import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		boolean[] checkNum = new boolean[3001];
		while(input.hasNextInt()){
			int n = input.nextInt();
			boolean jolly = true;
			for(int i = 1; i < n; i++){
				checkNum[i] = false;
			}
			int prev = input.nextInt();
			for(int i=1; i<n; i++){
				int curr = input.nextInt();
				int deff = Math.abs(prev-curr);
				if(deff >= n || deff <= 0 || checkNum[deff]){
					jolly = false;
					continue;
				}
				checkNum[deff] = true;
				prev = curr;
			}
			System.out.println(jolly ? "Jolly" : "Not jolly");
		}
	}
}