import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		int q=in.nextInt();
		for(int i=0;i<q;i++) {
			out.println(work());
		}
		out.flush();
	}
	long mod=1000000007;
	long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}
	int id[];
	long work() {
		int n=in.nextInt();
		int m=in.nextInt();
		long ret=0;
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] arr1,int[] arr2) {
				return arr1[2]-arr2[2];
			}
		});
		long sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int v=in.nextInt();
				pq.add(new int[] {i,j,v});
				sum+=v;
				if(pq.size()>6)pq.poll();
			}
		}
		if(m==1)return sum;
		if(n<=3) {
			while(pq.size()>0) {
				int[] p=pq.poll();
				if(pq.size()<n) {
					ret+=p[2];
				}
			}
			return ret;
		}
		int[][] A=new int[6][];
		for(int i=0;pq.size()>0;i++) {
			A[i]=pq.poll();
		}
		
		for(int i=0;i<6;i++) {
			for(int j=i+1;j<6;j++) {
				for(int k=j+1;k<6;k++) {
					out:
					for(int p=k+1;p<6;p++) {
						int s=A[i][2]+A[j][2]+A[k][2]+A[p][2];
						HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
						if(map.get(A[i][1])==null) {
							map.put(A[i][1],new ArrayList<>());
						}
						if(map.get(A[j][1])==null) {
							map.put(A[j][1],new ArrayList<>());
						}
						if(map.get(A[k][1])==null) {
							map.put(A[k][1],new ArrayList<>());
						}
						if(map.get(A[p][1])==null) {
							map.put(A[p][1],new ArrayList<>());
						}
						map.get(A[i][1]).add(A[i][0]);
						map.get(A[j][1]).add(A[j][0]);
						map.get(A[k][1]).add(A[k][0]);
						map.get(A[p][1]).add(A[p][0]);
						if(map.size()!=2) {
							ret=Math.max(ret, s);
							continue;
						}
						Integer l1=null,l2=null,r1=null,r2=null;
						for(int key:map.keySet()) {
							ArrayList<Integer> list=map.get(key);
							if(map.get(key).size()!=2) {
								ret=Math.max(ret, s);
								continue out;
							}
							if(l1==null) {
								l1=list.get(0);
								l2=list.get(1);
							}else {
								r1=list.get(0);
								r2=list.get(1);
							}
						}
						if((Math.abs(l1-l2)==2&&Math.abs(r1-r2)==2)||(Math.abs(l1-l2)!=2&&Math.abs(r1-r2)!=2)) {
							ret=Math.max(ret, s);
						}
					}
				}
			}
		}
		
		return ret;
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