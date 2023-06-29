import java.util.*;

public class ProblemA {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int t = s.nextInt();
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		
//		int x = 0 ;
		while(s.hasNextInt())
		{
			int i = s.nextInt();
			int j = s.nextInt();
			map.put(i,j);
//			x++;
//			if(x == 2)
//				break;
		}
		
		int count = 0;
		double left = -100000;
		double right;
		int size;
		for(Integer i : map.keySet())
		{
			size = map.get(i);
			right = (double)i - (double)size/2.0;
			
			if(right - left > t)
			{
				count+=2;
			}
			if(right - left == t)
			{
				count++;
			}
			
			left = (double)i + (double)size/2.0;
		}
		
		System.out.println(count);
	}

}
 