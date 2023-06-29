import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		work();
		out.flush();
	}
	long mod=998244353;
	long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}
	void work() {
		int n=in.nextInt();
		int[] A=new int[n];
		for(int i=0;i<n;i++)A[i]=in.nextInt();
		HashMap<Integer,Integer> map=new HashMap<>();
		HashMap<Integer,ArrayList<int[]>> rec=new HashMap<>();
		for(int i=0;i<n;i++) {
			for(int j=i,cur=0;j>=0;j--) {
				cur+=A[j];
				if(map.get(cur)==null) {
					map.put(cur,i);
					rec.put(cur,new ArrayList<>());
					rec.get(cur).add(new int[] {j,i});
				}else if(map.get(cur)<j) {
					map.put(cur,i);
					rec.get(cur).add(new int[] {j,i});
				}
			}
		}
		ArrayList<int[]> ret=null;
		for(ArrayList<int[]> list:rec.values()) {
			if(ret==null||ret.size()<list.size()) {
				ret=list;
			}
		}
		out.println(ret.size());
		for(int[] r:ret) {
			out.println((r[0]+1)+" "+(r[1]+1));
		}
	}
}	



class FastReader
{
	BufferedReader br;
	StringTokenizer st;

	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}

	public String next() 
	{
		if(st==null || !st.hasMoreElements())
		{
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() 
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}
}