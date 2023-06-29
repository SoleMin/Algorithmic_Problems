import java.util.*;

public class PC1229 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int[] x = new int[n];
		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
		}
		double[] ans = new double[n];
		for(int i = 0; i < n; i++){
			double maxY = r;
			for(int j = 0; j < i; j++){
				if(x[j] <= x[i] + 2*r && x[j] >= x[i] - 2*r){
					maxY = Math.max(maxY, ans[j] + Math.sqrt(4 * r * r - (Math.abs(x[i] - x[j])) * (Math.abs(x[i] - x[j]))));
				}
			}
			ans[i] = maxY;
		}
		for(int i = 0; i < n; i++){
			System.out.println(ans[i]);
		}
		sc.close();
	}
	
}
