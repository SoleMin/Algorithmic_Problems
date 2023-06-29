import java.util.Scanner;

public class DarkAssembly {
	static int n, A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		A = sc.nextInt();
		
		int[][] sen = new int[n][2];
		for (int i = 0; i < n; i++) {
			sen[i][0] = sc.nextInt();
			sen[i][1] = sc.nextInt();
		}
		
		//Simple:
		sen = sort(sen);
		int tmp = k, cnt = 0;
		for (int i = 0; i < n; i++) {
			int canTake = (100-sen[i][1])/10;
			if (canTake <= tmp) {tmp-=canTake; cnt++;}
		}
		
		if (cnt > n/2) {System.out.println(1); return;}
		
		//Less simple
		System.out.println(distribute(0, k, sen));
	}
	
	private static double distribute(int id, int k, int[][] sen) {
		if (id < n) {//distribute
			double max = 0;			
			for (int i=0;i<=k;i++) {
					sen[id][1]+=10*i;
					max = Math.max(max, distribute(id+1, k-i,sen));
					sen[id][1]-=10*i;
			}

			return max;
		}
		else return compute(sen);
		
	}
	
	private static double compute(int[][] sen) {
		double rez = 0;
		
		int dist = 1<<n;
		for (int i = 0; i < dist; i++) {
			double p = 1;
			int B = 0, cnt = 0;
			for (int j = 0; j < n; j++) { 
				double sL = Math.min(sen[j][1]/100.0, 1);  
				if ((i & (1<<j)) == 1<<j) { //yes 
					p *= sL;
					cnt++;
				}
				else { //no
					B+=sen[j][0];
					p *= (1-sL);
				}
			}
			if (cnt <= n/2) p *= (double) A/(A+B);
			rez +=p;
		}
		return rez;
	}
	
	private static int[][] sort(int[][] sen) {
		for (int i = 0; i < n; i++) {
			int[] min = sen[i];
			int minI = i;
			for (int j = i+1; j < n; j++) {
				if (sen[j][1] > min[1]) {
					minI = j;
					min = sen[j];
				}
			}
			int[] tmp = sen[i];
			sen[i] = min;
			sen[minI] = tmp;
		}
		
		return sen;
	}
}
