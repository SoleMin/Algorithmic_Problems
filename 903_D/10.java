import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class D {

	static HashMap<Long, Integer> comp = new HashMap<Long, Integer>();
	static HashMap<Integer, Long> rev = new HashMap<Integer, Long>();
	static long freq[];
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		long a[] = new long[n];
		long copy[] = new long[n];
		long sum = 0;
		for(int i = 0; i < n; i++){
			a[i] = in.nextLong();
			copy[i] = a[i];
			sum+=a[i];
		}
		Arrays.sort(copy);
		for(int i = 0; i < n; i++)	//Compress values to be 1-indexed
			if(!comp.containsKey(copy[i])){
				comp.put(copy[i],  (comp.size()+1));
				//rev.put(comp.get(copy[i]), copy[i]);
			}
			
	//	BIT bit = new BIT(n);
		
		freq = new long[n+1];
		Arrays.fill(freq, 0);
		for(int i = 0; i < n; i++){
			int v = comp.get(a[i]);
			freq[v]++;
		}
		
		long res = 0;
		BigInteger res2 = new BigInteger("0");
		for(int i = 0; i < n; i++){	//Go through each element in the array
			long x = a[i];
			//freq[comp.get(x)]--;
			//Find the amount of values equal to (x-1), x, and (x+1);
			long below = getFreq(x-1);
			long eq = getFreq(x);
			long above = getFreq(x+1);
			long other = (n-i)-below-eq-above;
			
		//	System.out.println("x= "+x+" b:"+below+"  e:"+eq+"  a:"+above);
			
			long leaveOut = below*(x-1) + eq*(x) + above*(x+1);
			long cur = (sum-leaveOut)-(x*other);

	//		System.out.println("sum:"+sum+"  leave:"+leaveOut+"  oth:"+other+"   cur:"+cur+"\n");
			res2 = res2.add(new BigInteger(""+cur));
			res += cur;
			sum -= x;
			freq[comp.get(x)]--;
			
		}
		System.out.println(res2);
	}
	
	static long getFreq(long n){
		if(!comp.containsKey(n)) return 0;
		else return freq[comp.get(n)];
	}
	
	
	

	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(String s) {
			try{
				br = new BufferedReader(new FileReader(s));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public FastScanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nextToken()	{
			while(st == null ||!st.hasMoreElements()){
				try {
				st = new StringTokenizer(br.readLine());}
				catch(IOException e) {
					e.printStackTrace();
				}			
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(nextToken());
		}
		long nextLong() {
			return Long.parseLong(nextToken());
		}
		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
		String next() {
			return nextToken();
		}
		
	}
	
	
}
