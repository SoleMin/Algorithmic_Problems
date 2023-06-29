import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		long[] arr=new long[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		
		long[] pre=new long[n];
		
		pre[0]=arr[0];
		
		for(int i=1;i<n;i++)
		{
			pre[i]=pre[i-1]+arr[i];
		}
		
		HashMap<Long,ArrayList<pair>> map=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				long key=pre[j]-pre[i]+arr[i];
				
				if(map.containsKey(key))
				{
					pair p=new pair(i+1,j+1);
					ArrayList<pair> temp=map.get(key);
					temp.add(p);
					
					map.put(key,temp);
				}
				else
				{
					ArrayList<pair> list=new ArrayList<>();
					pair p=new pair(i+1,j+1);
					list.add(p);
					
					map.put(key,list);
				}
			}
		}
		
		for(Map.Entry<Long,ArrayList<pair>> entry:map.entrySet())
		{
			ArrayList<pair> curr=entry.getValue();
			
			Collections.sort(curr,new comp());
		}
		
		long ans=0;
		long max=-1000000000000l;
		
		for(Map.Entry<Long,ArrayList<pair>> entry:map.entrySet())
		{
			ArrayList<pair> curr=entry.getValue();
			
			int count=1;
			int l=curr.get(0).l;
			int r=curr.get(0).r;
			
			for(int i=1;i<curr.size();i++)
			{
				if(curr.get(i).l>r)
				{
					count++;
					l=curr.get(i).l;
					r=curr.get(i).r;
				}
			}
			
			if(count>max)
			{
				max=count;
				ans=entry.getKey();
			}
			
		}
		
		System.out.println(max);
		
		ArrayList<pair> list=map.get(ans);
		
		System.out.println(list.get(0).l+" "+list.get(0).r);
		
		int l=list.get(0).l;
		int r=list.get(0).r;
		
		for(int i=1;i<list.size();i++)
		{
			if(list.get(i).l>r)
			{
				System.out.println(list.get(i).l+" "+list.get(i).r);
				l=list.get(i).l;
				r=list.get(i).r;
			}
		}
		
	}
	
}

class pair
{
	int l;
	int r;
	
	public pair(int l,int r)
	{
		this.l=l;
		this.r=r;
	}
}

class comp implements Comparator<pair>
{
	public int compare(pair a,pair b)
	{
		if(a.r<b.r)
			return -1;
		else if(a.r==b.r)
		{
			return b.l-a.l;
		}
		else
			return 1;
	}
}