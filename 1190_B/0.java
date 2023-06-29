import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		FS in = new FS();
		int N = in.nextInt();
		int ar[] = new int[N];
		for(int i = 0; i < N; i++) ar[i] = in.nextInt();
		Arrays.sort(ar);
		
		// All 0's
		if(ar[N-1] == 0) {
			p2Win();
			return;
		}
		// Two zeros
		if(N > 1 && ar[1] == 0) {
			p2Win();
			return;
		}
		
		int sameCnt = 0;
		for(int i = 0; i < N-1; i++) {
			if(ar[i] == ar[i+1]) sameCnt++;
		}
		
		if(sameCnt > 0) {
			for(int i = 0; i < N-1; i++) {
				if(ar[i] == ar[i+1]) {
					ar[i]--;
					break;
				}
			}
		}
		
		// Check if still any dupes
		for(int i = 0; i < N-1; i++) {
			if(ar[i] == ar[i+1]) {
				p2Win();
				return;
			}
		}		
		
		long min = 0;
		long tot = 0;
		for(int i = 0; i < N; i++) {
			min += i;
			tot += ar[i];
		}
		
		if((tot-min)%2 == 0) {
			if(sameCnt == 0) p2Win();
			else p1Win();
		}
		else {
			if(sameCnt == 0) p1Win();
			else p2Win();
		}
		
	}
	
	static void p1Win() {
		System.out.println("sjfnb");
	}
	static void p2Win() {
		System.out.println("cslnb");
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
