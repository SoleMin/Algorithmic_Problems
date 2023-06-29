import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class ProblemA {
	public static void main (String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s1=br.readLine();
		String[] s=s1.split(" ");
		int a[] = new int[n];
		for(int i = 0;i<n;i++)
		{
			a[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(a);
		System.out.println(findColour(a,n));
	}
	public static int findColour(int [] a , int n)
	{
		Map <Integer,Integer> mp = new HashMap<Integer,Integer>();
		int f=0;
		for(int i = 0; i<n;i++)
		{
			f=0;
			for (Map.Entry<Integer,Integer> entry : mp.entrySet()) 
			{
				if(a[i] % entry.getKey()==0)
				{
					f=1;
					break;
				}
			}
			if(f==0)
			{
				mp.put(a[i],1);
			}
				
		}
		return mp.size();
	}
}
