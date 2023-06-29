import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	static int N,K;
	static int ar[];
	public static void main(String[] args) {
		FS in = new FS();
		N = in.nextInt();
		K = in.nextInt();
		char c[] = in.next().toCharArray();
		ar = new int[N];
		for(int i = 0; i < N; i++) ar[i] = c[i]-'0';
		
		int suf[] = new int[2];
		int pref[] = new int[2];
		for(int i = 0; i < N; i++) {
			pref[ar[i]]++;
			if(i < N-1 && ar[i] != ar[i+1]) break;
		}
		for(int i = N-1; i >= 0; i--) {
			suf[ar[i]]++;
			if(i > 0 && ar[i] != ar[i-1]) break;
		}
		
		if(suf[0] + pref[0] + K >= N || suf[1] + pref[1] + K >= N) {
			p1Win();
			return;
		}
		
		boolean hasATie = false;
		for(int i = 0; i < N-K+1; i++) {
			// change [i, i+K-1] to 1's or 0's and see if p2 can win
			
			int newSuf[] = Arrays.copyOf(suf, 2);
			int newPref[] = Arrays.copyOf(pref, 2);
			
			// change to 0's. Opponent has to change to 0's as well to win
			for(int ch = 0; ch < 2; ch++) {
				if(newPref[ch] >= i) newPref[ch] = Math.max(newPref[ch], i+K);
				if(N-newSuf[ch] <= i+K) newSuf[ch] = Math.max(newSuf[ch], N-i);
			}
						
			boolean p2wins = (newSuf[0] + newPref[0] + K >= N && newSuf[1] + newPref[1] + K >= N);
			if(!p2wins) hasATie = true;
		}
		if(hasATie) draw();
		else p2Win();
		return;
	}
	
	static void p1Win() {
		System.out.println("tokitsukaze");
	}
	static void p2Win() {
		System.out.println("quailty");
	}
	static void draw() {
		System.out.println("once again");
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
				catch(Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
