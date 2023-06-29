import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class B {
	
	static class Scanner
	{
		BufferedReader rd;
		StringTokenizer tk;
		public Scanner() throws IOException
		{
			rd=new BufferedReader(new InputStreamReader(System.in));
			tk=new StringTokenizer(rd.readLine());
		}
		public String next() throws IOException
		{
			while(!tk.hasMoreTokens())
				tk=new StringTokenizer(rd.readLine());
			return tk.nextToken();
		}
		public int nextInt() throws NumberFormatException, IOException
		{
			return Integer.valueOf(this.next());
		}
	}
	
	static int N,K;
	static int[] array=new int[100010];
	
	public static void main(String args[]) throws IOException{
		Scanner sc=new Scanner();
		N=sc.nextInt();
		K=sc.nextInt();
		for(int i=0;i<N;i++)
			array[i]=sc.nextInt();
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		boolean flag=false;
		for(int i=0;i<N;i++){
			if (!map.containsKey(array[i])){
				map.put(array[i], i);
				if (map.size()==K){
					flag=true;
					break;
				}
			}
			else
				map.put(array[i], i);
		}
		if (!flag)
			System.out.println("-1 -1");
		else{
			Set<Integer> s=map.keySet();
			int l=Integer.MAX_VALUE;
			int r=Integer.MIN_VALUE;
			for(int k: s){
				int tmp=map.get(k);
				l=Math.min(l, tmp);
				r=Math.max(r, tmp);
			}
			System.out.println((l+1)+" "+(r+1));
		}
	}

}