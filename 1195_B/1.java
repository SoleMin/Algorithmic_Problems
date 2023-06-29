import java.util.*;
import java.io.*;
public class SportMafia {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long cur = -N;
		
		for(int i= 1; i<=N; i++) {
			
			cur++;
			cur+=i;
			if(cur==K) {
				System.out.println(N-i);
				break;
			}
		}
	}

}
