import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<String> list = new ArrayList<String>();
	static int[][] temp = new int[1001][2];
	static int[] c = new int[1001];
	static int[] back = new int[1001];
	static int[] seq;
	static int count;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		input();
		solve();

	}

	static void solve() {
		int i, j, max, index;
		c[0] = 1;
		back[0] = -1;
		for(i = 1; i < count; i++) {
			max = 1;
			index = -1;
			for(j = 0; j < i; j++) {
				if(c[j]+1 > max && temp[i][0] > temp[j][0]&& temp[i][1] < temp[j][1]) {
					max = c[j] + 1;
					index = j;
				}
			}
			c[i] = max;
			back[i] = index;
		}
		max = -1;
		index = -1;
		for(i = 0; i < count; i++) {
			if(max < c[i]) {
				max = c[i];
				index = i;
			}
		}
		j = index;
		int result = 0;
		int[] sol = new int[1001];
		while(j > 0) {
			sol[result] = j;
			j = back[j];
			result++;
		}
		
		System.out.println(result);
		for(i = result-1; i >= 0; i--) {
			System.out.println(seq[sol[i]]);
		}
	}

	static void input() throws IOException {
		count = 0;
		while(input.hasNextInt()) {
			temp[count][0] = input.nextInt();
			temp[count][1] = input.nextInt();
			count++;
		}
		seq = new int[count];
		for(int i = 0; i < count; i++)
			seq[i] = i + 1;

		int tem;
		int temp1[];
		for(int i = 0; i < count-1; i++) {
			for(int j = i+1; j < count; j++) {
				if(temp[j][0] == temp[i][0]) {
					if(temp[j][1] > temp[i][1]) {
						tem = seq[j];
						seq[j] = seq[i];
						seq[i] = tem;
						temp1 = temp[j];
						temp[j] = temp[i];
						temp[i] = temp1;
					}
				}
				if(temp[j][0] < temp[i][0]) {
					tem = seq[j];
					seq[j] = seq[i];
					seq[i] = tem;
					temp1 = temp[j];
					temp[j] = temp[i];
					temp[i] = temp1;
				}

			}
		}
	}

}