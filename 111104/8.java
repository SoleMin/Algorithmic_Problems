import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		ArrayList<Integer[]> ar = new ArrayList<Integer[]>();
		Integer[] a= {0,0};
		ar.add(a);

		while(input.hasNext()) {
			Integer[] t = new Integer[2];
			t[0]=input.nextInt(); // 체중
			t[1]=input.nextInt(); // 체력
			ar.add(t);
		}

		Collections.sort(ar, (o1, o2) -> o1[1].compareTo(o2[1]));

		int[][] dp= new int[ar.size()][ar.size()];

		for(int i =1; i<ar.size(); i++) {
			dp[0][i]=1000000000;
		}

		for(int i=1; i<ar.size(); i++) {
			for(int j=1; j<ar.size(); j++) {
				if(dp[i-1][j-1]+ar.get(i)[0] <= ar.get(i)[1]) {
					dp[i][j]=Math.min(dp[i-1][j-1]+ar.get(i)[0], dp[i-1][j]);
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		
		
		int max= 0;
		int result=0;
		for(int j=1; j<ar.size(); j++) {
			if(dp[ar.size()-1][j]!= 1000000000 && max<dp[ar.size()-1][j]) {
				max=dp[ar.size()-1][j];
				result=j;
			}
		}
		System.out.println(result);

		input.close();
	}

}
