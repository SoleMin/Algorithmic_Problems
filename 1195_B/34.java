import java.util.*;

 
public class Main {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		long n = sc.nextLong(), k = sc.nextLong();
		long ans = 0, sum = 0;
		while(ans < n) {
			if(sum - (n-ans) == k) break;
			ans++;
			sum += ans;
		}
		sc.close();
		System.out.println(n-ans);
	}
    
   
}