import java.util.*;
import java.io.*;
public class B{
	public static void main(String[] args)
	{
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		for(int tt=0;tt<t;tt++)
		{
			int n = fs.nextInt();
			int[] arr = fs.readArray(n);
			List<String> ans = new ArrayList();
			List<Integer> temp = new ArrayList();
			temp.add(arr[0]);
			ans.add(""+arr[0]);
			for(int i=1;i<n;i++)
			{
				int ch = arr[i];
				if(ch == 1)
				{
					temp.add(1);
					StringBuilder sb = new StringBuilder();
					for(int j=0;j<temp.size();j++)
					{
						sb.append(temp.get(j));
						if(j != temp.size()-1)
						{
							sb.append('.');
						}
					}
					ans.add(sb.toString());
				}
				else
				{
					int j = temp.size()-1;
					while(j>=0)
					{
						if(ch - temp.get(j) == 1)
						{
							temp.set(j,ch);
							break;
						}
						else
						{
							j--;
						}
					}
					int extra = temp.size()-1;
					while(extra>j)
					{
						temp.remove(temp.size()-1);
						extra--;
					}
					StringBuilder sb = new StringBuilder();
					for(int jj=0;jj<temp.size();jj++)
					{
						sb.append(temp.get(jj));
						if(jj != temp.size()-1)
						{
							sb.append('.');
						}
					}
					ans.add(sb.toString());
				}
//				out.println("Here: "+temp);
			}
			for(String str:ans)
			{
				out.println(str);
			}
		}
		out.close();
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	public static int[] sort(int[] arr)
	{
		List<Integer> temp = new ArrayList();
		for(int i:arr)temp.add(i);
		Collections.sort(temp);
		int start = 0;
		for(int i:temp)arr[start++]=i;
		return arr;
	}
}