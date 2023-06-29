import java.io.*;
import java.util.Scanner;
class Main {
	static int n;
	static int[] ti = new int[1000];
	static int[] si = new int[1000];
	static int[] result = new int[1000];
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int i, j;
		int t = input.nextInt();
		for(i = 0; i < t; i++){
			input();
			solve();
			if(i > 0)
				System.out.println();
			for(j = 0; j < n - 1; j++)
				System.out.print(result[j] + 1 + " ");
			System.out.println(result[n - 1] + 1);
		}
		input.close();
	}
	static void solve(){
		int i, j, temp;
		for(i = 0; i < n; i++)
			result[i] = i;
		for(i = 1; i < n; i++){
			for(j = 0; j < n - i; j++){
				if(ti[result[j]] * si[result[j + 1]] > ti[result[j + 1]] * si[result[j]]){
					temp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = temp;
				}
			}
		}
	}
	static void input(){
		n = input.nextInt();
		for(int i = 0; i < n; i++){
			ti[i] = input.nextInt();
			si[i] = input.nextInt();
		}
	}
}