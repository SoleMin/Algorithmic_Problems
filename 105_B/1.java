
import java.util.Scanner;

public class DarkAssembly {
	static double ans = 0;
	static int n = 0 ;
	static double [] l;
	static int [] b;
	static double a;
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int k = in.nextInt();
		a = in.nextInt();
		l = new double[n];
		b = new int[n];
		for(int i= 0 ; i < n ; i++){
			b[i]=in.nextInt();
			l[i]=in.nextInt()/100d;
		}
		make(0,k);
		System.out.println(ans);
	}
	public static void make(int i ,int k){
		if(k==0){
			ans = Math.max(prob(), ans);
			if(ans >= 1){
				System.out.println(1);
				System.exit(0);
			}
			return;
		}
		if(i==n){
			ans = Math.max(prob(), ans);
			if(ans >= 1){
				System.out.println(1);
				System.exit(0);
			}
			return;
		}
		int f = i;
		if(l[i]<0.95){
			l[i]+=0.1d;
			make(i,k-1);
			l[i]-=0.1d;
		}
		make(f+1,k);
		
	}
	public static double prob(){
		double ans = 0;
		for(int i = 0 ; i < (1<<n) ; i++){
			double B = 0 ;
			double t = 1;
			for(int j = 0 ; j < n; j++){
				if ( (i & ( 1 << j)) != 0){
					t*=l[j];
					if(t==0) 
						break;
				}
				else{
					t*=1-l[j];
					if(t==0) 
						break;
					B+=b[j];
				}
			}
			if(Integer.bitCount(i)*2 <= n){
				t*= a/(a+B);
			}
			ans+=t;
			
		}
		return ans;
		
	}
	
}