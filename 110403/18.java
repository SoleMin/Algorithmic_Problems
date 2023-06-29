import java.util.Scanner;
import java.util.Arrays;
class Main {
	
	public static int mini(int[] t, int n){
		int time = 0;
		if(n == 2)
			time += t[0] + t[1] + t[2];
		else if(n == 1)
			time += t[1];
		else if(n == 0)
			time += t[0];
		return time;
	}
	
	public static int s1(int[] t, int i){
		return t[1] + t[0] + t[i] + t[1];
	}
	
	public static int s2(int[] t, int i){
		 return t[0]*2 + t[i] + t[--i];
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testCaseNum;
		testCaseNum = sc.nextInt();
		while(testCaseNum-- > 0){
			int n = sc.nextInt();
			int size = n-1;
			int[] t = new int[n];
			int t1, t2, time=0;
			while(n > 0)
				t[--n] = sc.nextInt();
			
			Arrays.sort(t);
			while(size > 2){
				t1 = s1(t, size);
				t2 = s2(t, size);
				if(t1 <= t2)
					time += t1;
				else
					time += t2;
				size = size-2;
			}
			time += mini(t, size);
			
			System.out.println(time);
			System.out.println();

		}
	}}