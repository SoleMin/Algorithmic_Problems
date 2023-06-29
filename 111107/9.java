import java.util.*;
class Main {
	
	static int MAXG = 1000, MAXC = 5000, guest_num, stick_num;
	static int[] length = new int[MAXC];
	static int[][] dynamic = new int[MAXG + 9][MAXC + 1];
	
	public static void solve() {
		int j, k, temp, min, ischeck;
		
		temp = stick_num - (3 * guest_num) + 2;
		for(j = 1; j <= guest_num; j++) {
			ischeck = j * 2;
			for(k = 0; k <= temp; k++) {
				if(k >= ischeck) {
					min = length[k -1] - length[k -2];
					min = dynamic[j-1][k-2] + min * min;
					if(dynamic[j][k-1] > min)
						dynamic[j][k] = min;
					else
						dynamic[j][k] = dynamic[j][k-1];
				}
				else
					dynamic[j][k] = 9999999;
			}
			dynamic[j][temp+1] = dynamic[j][temp];	
			temp += 3;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int i, j, t;
		
		t = input.nextInt();
		for(i = 0; i < t; i++) {
			guest_num = input.nextInt();
			stick_num = input.nextInt();
			
			guest_num += 8;
			for(j = 0; j < stick_num; j++)
				length[j] = input.nextInt();
			
			solve();
			System.out.println(dynamic[guest_num][stick_num-1]);
		}
	}
}