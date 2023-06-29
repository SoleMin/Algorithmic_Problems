import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();
		scan.nextLine();
		while(casenum-- > 0){
			scan.nextLine();
			int n = scan.nextInt();
			scan.nextLine();
			int[] N = new int[n];
			while(n-- > 0){
				N[n] = scan.nextInt();
			}
			Arrays.sort(N);
			int time=0;
			int range = N.length;
			for(;range>3;range-=2){
				int time1 = N[0] + 2*N[1] + N[range-1];
				int time2 = 2*N[0] + N[range-2] + N[range-1];
				if(time1 > time2){
					time += time2;
				}
				else{
					time += time1;
				}
			}
			if(range==3){
				time += N[0] + N[1] + N[2];
			}
			else{
				time += N[range-1];
			}
			System.out.println(time);
			System.out.println();
		}
	}
}