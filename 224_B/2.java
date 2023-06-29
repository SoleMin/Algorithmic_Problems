import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class B {
	
	// -- DEBUG switch --
	static final boolean DBG = false;
	static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static int[] e = new int[100001];
	
	public static void main(String[] args) throws IOException {
		int n = i(), k = i(), cnt = 0;
		int[] a = new int[n+1];
		for (int i=1; i<=n; i++){
			a[i] = i();
			if (e[a[i]] == 0)
				cnt++;
			e[a[i]]++;
		}
		if (k > cnt){
			pw.println("-1 -1");
			pw.close();
			return;
		}
		if (cnt == n){
			pw.print("1 " + k);
			pw.close();
			return;
		}
		if (k == 1){
			pw.println("1 1");
			pw.close();
			return;
		}
		Arrays.fill(e, 0);
		int i = 1, j = 0, unik = 0, start = 0, end = 0, len = n, m = 0;


		if (e[a[i]] == 0){
			unik++;
		}
		e[a[i]]++;
		while (i+1<=n && a[i+1] == a[i]){
			i = i+1;
		}		
		
		j = i+1;
		
		while (j <= n){
			if (e[a[j]] == 0){
				unik++;
				if (unik == k){
					while (e[a[i]] > 1){
						e[a[i]]--;
						i++;
						while (i+1<=n && a[i+1] == a[i]){
							i = i+1;
						}	
					}
					m = j - i + 1;
					if (m < len){
						start = i; end = j; len = m;
						if (m == k)
							break;
					}
					
					while (i <=n && unik == k){
						e[a[i]]--;
						if (e[a[i]] == 0)
							unik--;
						i++;
						
						while (i+1<=n && a[i+1] == a[i]){
							i = i+1;
						}					
					}

				}
			}
			e[a[j]]++;
			while (j+1<=n && a[j+1] == a[j]){
				j++;
			}			
			j++;

		}
		pw.println(start + " " + end);	
		pw.close();
	}
	
	static int i() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	
	static long l() throws IOException {
		st.nextToken();
		return (long)st.nval;
	}

	static double d() throws IOException {
		st.nextToken();
		return st.nval;
	}
	static String s() throws IOException{
		st.nextToken();
		return st.sval;
	}
}
