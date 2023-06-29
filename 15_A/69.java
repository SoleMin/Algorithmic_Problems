import java.util.*;
import java.io.*;

public class a {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[][] xa = new int[n][2];
		for(int i=0; i<n; ++i) {
			xa[i][0] = sc.nextInt();
			xa[i][1] = sc.nextInt();
		}
	    Arrays.sort(xa, new Comparator<int[]>(){
            @Override
            public int compare(int[] a0, int[] a1){
                return a0[0]-a1[0];
            }
        });
		  int ans=2;
	        for(int i=0; i<n-1; i++){
	            int s=(xa[i+1][0]*2-xa[i+1][1])-(xa[i][0]*2+xa[i][1]);
	            if(s>t*2){
	                ans+=2;
	            }else if(s==t*2){
	                ans++;
	            }
	        }
	        System.out.println(ans+"");
	}
}