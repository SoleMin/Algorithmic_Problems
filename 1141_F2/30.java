import java.io.*;
import java.util.*;
public class Main
{
	HashMap<Integer,Pair> map;
	int n,a[];
	private void solve()throws IOException
	{
		n=nextInt();
		a=new int[n+1];
		for(int i=1;i<=n;i++)
			a[i]=nextInt();
		map=new HashMap<>();
		for(int i=1;i<=n;i++)
		{
			int sum=0;
			for(int j=i;j>=1;j--)
			{
				sum+=a[j];
				if(!map.containsKey(sum))
					map.put(sum,new Pair(i,1));
				else
				{
					Pair p=map.get(sum);
					if(p.pos<j)
						map.put(sum,new Pair(i,p.cnt+1));
				}
			}
		}
		int sum=0,ans=0;
		for(int i:map.keySet())
			if(map.get(i).cnt>ans)
			{
				ans=map.get(i).cnt;
				sum=i;
			}
		out.println(ans);
		ArrayList<String> list=new ArrayList<>();
		for(int i=1,prev=0;i<=n;i++)
		{
			int s=0;
			for(int j=i;j>=1;j--)
			{
				s+=a[j];
				if(s==sum && j>prev)
				{
					list.add(j+" "+i);
					prev=i;
				}
			}
		}
		for(String s:list)
			out.println(s);
	}
	class Pair{
	    int pos,cnt;
	    Pair(int a,int b){
	        pos=a;
	        cnt=b;
	    }
	}
	 
	///////////////////////////////////////////////////////////

	public void run()throws IOException
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		st=null;
		out=new PrintWriter(System.out);

		solve();
		
		br.close();
		out.close();
	}
	public static void main(String args[])throws IOException{
		new Main().run();
	}
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	String nextToken()throws IOException{
		while(st==null || !st.hasMoreTokens())
		st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	String nextLine()throws IOException{
		return br.readLine();
	}
	int nextInt()throws IOException{
		return Integer.parseInt(nextToken());
	}
	long nextLong()throws IOException{
		return Long.parseLong(nextToken());
	}
	double nextDouble()throws IOException{
		return Double.parseDouble(nextToken());
	}
}