import java.io.*;
import java.util.*;

public class utkarsh{
	BufferedReader br;
	PrintWriter out;

	int game(int s, int mid, int e, int[] a){
		int i, j, n, m;
		n = mid - s + 1;
		m = e - mid;
		int b[] = new int[n];
		int c[] = new int[m];
		for(i = 0; i < n; i++)	b[i] = a[s + i];
		for(j = 0; j < m; j++)	c[j] = a[mid + 1 + j];
		i = j = 0;
		int ans = 0;
		for(int k = s; k <= e; k++){
			if(i == n){
				a[k] = c[j++];
			}else if(j == m){
				a[k] = b[i++];
			}else{
				if(b[i] < c[j]){
					a[k] = b[i++];
				}else{
					a[k] = c[j++];
					ans += n - i;
				}
			}
		}
		return ans;
	}

	int play(int s, int e, int[] a){
		if(s >= e)	return 0;
		int m = (s + e) >> 1;
		return play(s, m, a) + play(m+1, e, a) + game(s, m, e, a);
	}

	void solve(){
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int i, j, k, l, r, n;
		n = ni();
		int a[] = new int[n];
		int d[] = new int[n];
		for(i = 0; i < n; i++) {
			a[i] = ni();
			d[i] = a[i];
		}
		int ans = (play(0, n-1, d) & 1);

		int q = ni();
		while(q-- > 0){
			l = ni();	r = ni();
			ans ^= ((r - l + 1) * (r - l) / 2);
			//out.println(ans);
			if((ans & 1) > 0)	out.println("odd");
			else				out.println("even");
		}

		out.flush();
	}

	int ni(){
		return Integer.parseInt(ns());
	}

	String ip[];
	int len, sz;

	String ns(){
		if(len >= sz){
			try{
				ip = br.readLine().split(" ");
				len = 0;
				sz = ip.length;
			}catch(IOException e){
				throw new InputMismatchException();
			}
			if(sz <= 0)	return "-1";
		}
		return ip[len++];
	}

	public static void main(String[] args){	new utkarsh().solve();	}
}