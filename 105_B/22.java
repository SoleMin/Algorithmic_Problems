import java.io.*;
import java.util.*;







public class B2 {
	String s = null;

	String[] ss = null;
	int[][] sn = null;
	int n = 0;
	double ans = 1;
	int A = 0;
	public void run() throws Exception{

		BufferedReader br = null;
		File file = new File("input.txt");
		if(file.exists()){
			br = new BufferedReader(new FileReader("input.txt"));
		}
		else{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	
		s = br.readLine();
		ss = s.split(" ");
		
		
		
		n = Integer.parseInt(ss[0]);
		int k = Integer.parseInt(ss[1]);
		A = Integer.parseInt(ss[2]);
		sn = new int[n][2];

		for(int i = 0; i < n; i++){
			s = br.readLine();
			ss = s.split(" ");
			sn[i][0] = Integer.parseInt(ss[0]);
			sn[i][1] = Integer.parseInt(ss[1]);
		}

		int num = 0;
		for(int i = 0; i < n; i++){
			num += (100 - sn[i][1]) / 10;
		}
		if(k >= num){
			System.out.println("1.0");
			return;
		}
		
		check(0, k, sn);
		
		ans = 1 - ans;
		System.out.println(ans);
		
	}
	
	void check(int i, int k, int[][] sn){
		if(i == n && k == 0){
			check2(sn);
			return;
		}
		else if(i == n && k > 0){
			return;
		}
		else if(k == 0){
			check(i+1, k, sn);
		}
		else{
			for(int j = 0; j <= k; j++){
				if(sn[i][1] + j * 10 <= 100){
					int[][] nsn = copy(sn);
					nsn[i][1] += j * 10;
					check(i+1, k - j, nsn);
				}
			}
		}
	}
	
	void check2(int[][] sn){
		List<Integer> target = new ArrayList<Integer>();
		int h = 0;
		for(int i = 0; i < sn.length; i++){
			if(sn[i][1] != 100){
				target.add(i);
			}
			else{
				h++;
			}
		}
		if(h  > n / 2){
			System.out.println("1.0");
			System.exit(0);	
		}
		int makemax = n - h;
		int makemin = (n+1)/2;
		double ma = 0;
		for(int i = makemax; i >= makemin; i--){
			Combination c = new Combination(makemax, i);
			Iterator<int[]> ite = c.iterator();
			
			while(ite.hasNext()){
				int[] ret = ite.next();
				Set<Integer> make = new HashSet<Integer>();
				for(int j = 0; j < ret.length; j++){
					if(ret[j] > 0){
						make.add(target.get(j));
					}
				}
				double makeK = 1;
				int B = 0;
				for(int j = 0; j < n; j++){
					int perc = 0;
					if(make.contains(j)){
						perc = 100 - sn[j][1];
						B += sn[j][0];
					}
					else{
						perc = sn[j][1];
					}
					makeK *= ((double)perc / 100);
				}
				ma += makeK * (1 - (double)A/(A+B));
			}
			
		}
		ans = Math.min(ans, ma);
	}
	
	int[][] copy(int[][] sn){
		int[][] csn = new int[sn.length][2];
		
		for(int i = 0; i < sn.length; i++){
			csn[i][0] = sn[i][0];
			csn[i][1] = sn[i][1];
		}
		
		return csn;
	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		B2 t = new B2();
		t.run();

	}

	
	public class Combination implements Iterable<int[]> {
		private final int max;
		private final int select;
		
		public Combination(int max, int select) {
			if (max < 1 || 62 < max) {
				throw new IllegalArgumentException();
			}
			this.max = max;
			this.select = select;
		}
	
		public Iterator<int[]> iterator() {
			return new CombinationIterator(max, select);
		}
		
		private class CombinationIterator implements Iterator<int[]> {
			private long value;
			private final long max;
			private final int size;
			private int[] ret = null;
			public CombinationIterator(int max, int select) {
				this.value = (1L << select) - 1L;
				this.size = max;
				this.max = 1L << max;
				this.ret = new int[size];
			}

	
			public boolean hasNext() {
				return value < max;
			}


			public int[] next() {
				long stock = value;
				value = next(value);
				
				for(int i = 0; i < size; i++){
					long tmp = stock >> i;
					tmp = tmp & 1;
					ret[i] = (int)tmp;
				}
				
				return ret;
			}

	
			public void remove() {
				throw new UnsupportedOperationException();
			}

			private long next(long source) {
				long param1 = smallestBitOf(source);
				long param2 = param1 + source;
				long param3 = smallestBitOf(param2);
				long param5 = (param3 / param1) >>> 1;
				return param5 - 1 + param2;
			}

			private long smallestBitOf(long source) {
				long result = 1L;
				while (source % 2 == 0) {
					source >>>= 1;
					result <<= 1;
				}
				return result;
			}
		}
	}
}
