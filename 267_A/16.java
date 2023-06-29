//david alexander
import java.util.*;

public class Subtract {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a,b;
		String answer = "";
		while(n!=0){
			a = sc.nextInt();
			b = sc.nextInt();
			answer += solve(a,b) + "\n";
			n--;
		}
		System.out.println(answer);
	}
	
	public static int solve(int a, int b){
		int count = 0;
		int div;
		int mod;
		while(true){
			if(a >= b){
				div = a/b;
				mod = a%b;
				count += div;
				if(mod==0){
					return count;
				}
				else{
					a = mod;
				}
			}
			else{
				div = b/a;
				mod = b%a;
				count += div;
				if(mod==0){
					return count;
				}
				else{
					b = mod;
				}
			}
		}
	}
}
