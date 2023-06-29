import java.io.*;
import java.util.*;
import java.math.*;
class Main {
	static final int N_MAX = 10000;
	static int n, hn, h4n;
	static BigInteger[] ha = new BigInteger[N_MAX];
	static BigInteger[] ha4 = new BigInteger[N_MAX];
	
	public static void solve(int n){
		hanoi(n);
		int k;
		BigInteger temp;
		for(; h4n <= n; h4n++){
			ha4[h4n]=ha4[h4n-1].add(ha4[h4n-1]).add(new BigInteger("1"));
			for( k = h4n-2; k > 0; k--){
				temp = ha4[k].add(ha4[k]).add(ha[h4n-k]);
				if(ha4[h4n].compareTo(temp)==1)
					ha4[h4n] = temp.add(new BigInteger("0"));
				else
					break;
			}
		}
	}
	public static void hanoi(int n){
		for(int i = 2; i < n; i++){
			ha[i] = ha[i-1].add(ha[i-1]).add(new BigInteger("1"));
		}
			
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		ha[0]= new BigInteger("0");
		ha[1]= new BigInteger("1");
	
	
		ha4[0]= new BigInteger("0");
		ha4[1]= new BigInteger("1");
		ha4[2]= new BigInteger("3");
		
		hn =2;
		h4n = 2;
		while(input.hasNext()){
			int n = input.nextInt();
			solve(n);
			System.out.println(ha4[n]);
		}
	}
}