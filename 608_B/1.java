import java.util.*;

public class CodeForces_C7{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] a = input.next().toCharArray();
		char[] b = input.next().toCharArray();
		int n = a.length;
		int m = b.length;
		int[] arr = new int[200005];
		for(int i = 1;i<=m;i++){
			arr[i] = arr[i-1] + b[i-1] - '0';
		}
		long ans = 0;
		for(int i = 0;i<n;i++){
			if(a[i] == '0'){
				ans+= (long)arr[m-n+i+1] - arr[i]; 
			}
			else{
				ans+= (long)m-n+1 - (arr[m-n+i+1] - arr[i]);
			}
		}
		System.out.println(ans);
	}
}