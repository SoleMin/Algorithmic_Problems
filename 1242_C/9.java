import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C {

	static int K;
	static int sz[];
	static long vs[][];
	static long curSum[];
	static HashMap<Long, Integer> valToBucket;
	static long sum;
	static int maskIfPick[][];
	static int dp[];
	
	static int pickId[];
	static int newBox[];
	public static void main(String[] args) {
		FS in = new FS();
		K = in.nextInt();
		sz = new int[K];
		valToBucket = new HashMap<Long, Integer>();
		vs = new long[K][];
		curSum = new long[K];
		sum = 0;
		for(int i = 0; i < K; i++) {
			sz[i] = in.nextInt();
			vs[i] = new long[sz[i]];
			for(int j = 0; j < sz[i]; j++) {
				long v = in.nextLong();
				sum += v;
				curSum[i] += v;
				vs[i][j] = v;
				valToBucket.put(v, i);
			}
		}
		
		if(sum % K != 0) {
			System.out.println("No");
			return;
		}
		
		sum /= K;
		maskIfPick = new int[K][];
		//go through if i pick each node
		for(int i = 0; i < K; i++) {
			maskIfPick[i] = new int[sz[i]];
			for(int j = 0; j < sz[i]; j++) {
				
				int mask = (1<<i);
				boolean works = false;
				long curLookfor = (sum - (curSum[i]-vs[i][j]));
				while(true) {
					if(!valToBucket.containsKey(curLookfor)) break;
					int nextBucket = valToBucket.get(curLookfor);
					if(nextBucket == i) {
						works = curLookfor == vs[i][j];
						break;
					}
					else if((mask & (1<<nextBucket)) > 0) break;
					else {
						mask |= (1<<nextBucket);
						curLookfor = (sum - (curSum[nextBucket]-curLookfor));
					}
				}
				if(works) maskIfPick[i][j] = mask;
			}
		}
//		System.out.println("S= "+sum);
		dp = new int[1<<K];
		Arrays.fill(dp, -1);
		int res = go(0);
		if(res == 0) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
			pickId = new int[K];
			newBox = new int[K];
			Arrays.fill(pickId, -1);
			buildback(0);
			for(int i = 0; i < K; i++) {
				System.out.println(vs[i][pickId[i]]+" "+(newBox[i]+1));
			}
		}
		
	}
	
	static void pick(int i, int j) {
//		System.out.println(" Pick "+i+" "+j);
		if(pickId[i] != -1) return;
		pickId[i] = j;
		
		long curLookfor = (sum - (curSum[i]-vs[i][j]));
		int nextBucket = valToBucket.get(curLookfor);
		newBox[nextBucket] = i;
		for(int k = 0; k < sz[nextBucket]; k++) {
			if(vs[nextBucket][k] == curLookfor) pick(nextBucket, k);
		}
	}
	
	static int go(int mask) {
		if(mask+1 == (1<<K)) return 1; //got to end
		if(dp[mask] != -1) return dp[mask];
		//get first bit that's off
		int bit = -1;
		for(int i = 0; i < K; i++) {
			if((mask & (1<<i)) == 0) { bit = i; break;}
		}
		
		int res = 0;
		//loop through things to take for this bit
		for(int take = 0; take < sz[bit]; take++) {
			int newMask = maskIfPick[bit][take];
			if(newMask == 0 || (mask & newMask) > 0) continue;
			res = (res | go(mask | newMask));
		}
		
		return dp[mask] = res;
	}
	
	static void buildback(int mask) {
		if(mask+1 == (1<<K)) return; //got to end
		//get first bit that's off
		int bit = -1;
		for(int i = 0; i < K; i++) {
			if((mask & (1<<i)) == 0) { bit = i; break;}
		}
		
		int res = 0;
		//loop through things to take for this bit
		for(int take = 0; take < sz[bit]; take++) {
			int newMask = maskIfPick[bit][take];
			if(newMask == 0 || (mask & newMask) > 0) continue;
			res = (res | go(mask | newMask));
			if(res == 1) {
				pick(bit, take);
				buildback(mask | newMask);
				break;
			}
		}
	}
	
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		double nextDouble() { return Double.parseDouble(next());}
		long nextLong() { return Long.parseLong(next());}
	}
	
}
