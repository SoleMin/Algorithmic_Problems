import java.util.Arrays;
import java.util.Scanner;
 
public class Codeforce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int color = 0;
		Arrays.sort(arr);
		for(int i=0; i<n; i++) {
			if(arr[i]!=0) {
				int col = arr[i];
				color++;
				for(int j=i; j<n; j++) {
					if(arr[j]%col==0) arr[j]=0;
				}
			}
		}
		System.out.println(color);
		sc.close();
	}
}