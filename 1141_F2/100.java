import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b {

	public static void main(String[] rgs)
	{
		Scanner s=new Scanner(System.in);

		int n=s.nextInt();
		long[] arr=new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=s.nextLong();
		}
		HashMap<Long,ArrayList<pair>> map=new HashMap<>();
	
		ArrayList<pair> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			long sum=0;
			for(int j=i;j<n;j++) {
				sum=sum+arr[j];
				pair ob=new pair(i,j);
				if(map.containsKey(sum))
				{
					ArrayList p=map.get(sum);
					p.add(ob);
					map.put(sum, p);
					
				}else {
					ArrayList<pair> listt=new ArrayList<>();
					listt.add(ob);
					map.put(sum,listt);
				}
			}
		}
	
		
		
		
		
		long in=-1;
		int max=0;
		
		for(Map.Entry<Long, ArrayList<pair>> entry:map.entrySet()) {
			int l=1;
			ArrayList<pair> p=entry.getValue();
			Collections.sort(p,new comp());
			int now=p.get(0).end;
			for(int j=0;j<p.size();j++) {
				
			
			
				if(p.get(j).st>now) {
					l++;
					now=p.get(j).end;
					
				}
			
				
			}
			
			if(l>max) {
				max=l;
				in=entry.getKey();
			}
		}
		
		System.out.println(max);
		
		
		ArrayList<pair> d=map.get(in);
		int now=-1;
		for(int j=0;j<d.size();j++) {
		
			if(d.get(j).st>now) {
				System.out.println((d.get(j).st+1)+" "+(d.get(j).end+1));
				now=d.get(j).end;
				}
		
			
		}
		
		
		
		
	}
}
class pair{
	//long val;
	int st;
	int end;
	public pair(int st,int end) {
		//this.val=val;
		this.st=st;
		this.end=end;
	}
}
class comp implements Comparator<pair>{
	
	public int compare(pair h,pair j) {
		
		if(h.end<j.end) {
			return -1;
		}else if(h.end==j.end) {
			if(h.st<j.st) {
				return 1;
			}else if(h.st==j.st) {
				return 0;
			}else {
				return -1;
			}
		}else {
			return 1;
		}
	}
}