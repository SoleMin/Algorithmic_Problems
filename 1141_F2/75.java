import java.util.HashMap;
import java.util.Scanner;

public class Main{
	
	int[] ints;
	int[] prefix;
	
	public static void main(String[] args)
	{
		new Main().run();
	}
	
	public void run()
	{
		Scanner file = new Scanner(System.in);
		int N = file.nextInt();
		ints = new int[N];
		for(int i = 0;i<N;i++)
			ints[i] = file.nextInt();
		prefix = new int[N];
		prefix[0] = ints[0];
		for(int i =1;i<prefix.length;i++)
			prefix[i] = prefix[i-1]+ints[i];
		HashMap<Integer,Integer> ending = new HashMap<>();//ending for each sum
		HashMap<Integer,Integer> amount = new HashMap<>();//k for each sum
		for(int end = 0;end<prefix.length;end++)
		{
			for(int start = 0;start<=end;start++)
			{
				int sum = sum(start,end);
				if(!ending.containsKey(sum))
					ending.put(sum, -1);
				if(!amount.containsKey(sum))
					amount.put(sum,0);
				if(ending.get(sum)<start)
				{
					amount.put(sum,amount.get(sum)+1);
					ending.put(sum,end);
				}
			}
		}
		int max = 0;
		int maxnum = -1;
		for(int x:amount.keySet())
		{
			if(amount.get(x)>max)
			{
				max = amount.get(x);
				maxnum = x;
			}
		}
		System.out.println(max);
		HashMap<Integer,Integer> occurrence = new HashMap<Integer,Integer>();
		occurrence.put(0,0);
		for(int i = 0;i<prefix.length;i++)
		{
			if(occurrence.containsKey(prefix[i]-maxnum))
			{
				System.out.println(occurrence.get(prefix[i]-maxnum)+1+" "+(i+1));
				occurrence.clear();
			}
			occurrence.put(prefix[i],i+1);
		}
	}
	
	public int sum(int L, int R)
	{
		return prefix[R] - prefix[L] + ints[L];
	}
	
}
