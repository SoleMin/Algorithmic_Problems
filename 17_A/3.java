import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
		
	void solve() throws IOException {
		int n=ni();
		int k=ni();
		boolean[] t = new boolean[n+1];
		for(int i=2;i<=n;i++){
		t[i]=false;
		}
		int p=2;
		
		while(true){
			int pointer=2;
		while(pointer*p<=n){
			t[pointer*p]=true;
			pointer++;
		}

		boolean flag=false;
		for(int i=p+1;i<=n;i++){
			if(!t[i]){p=i;flag=true;break;}
		}
		if(!flag)break;
		}
		List<Integer> lst=new ArrayList<Integer>();

		int countN=0;
		for(int i=1;i<=n;i++){
			if(!t[i]){lst.add(i);countN++; }
		}
		int count=0;
		
		String resulPO="NO";
		for(int i=2;i<countN;i++){
			
			boolean result=false;
			for(int j=0;j<i;j++){
				if(lst.get(j)+lst.get(j+1)+1==lst.get(i)){
					result=true;
					//out.println(lst.get(j)+"+"+lst.get(j+1)+"+"+1+"=="+lst.get(i));
					break;
				}
			}
			if(result)count++;
		}
		if(count>=k)resulPO="YES";
		else resulPO="NO";
		out.print(resulPO);
		
	}
	
	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		in.close();
		out.close();
	}

	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.valueOf(ns());
	}

	long nl() throws IOException {
		return Long.valueOf(ns());
	}

	double nd() throws IOException {
		return Double.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}