
import java.util.*;
import java.math.*;
public class codeforces {
	 public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++)
			data[i]=sc.nextInt();
		Arrays.sort(data);
		if(data[n-1]!=1)
			data[n-1]=1;
		else
			data[n-1]=2;
		Arrays.sort(data);
		for(int i=0;i<n;i++)
		{
			System.out.print(data[i]);
			if(i!=n-1)
				System.out.print(" ");
		}
			
		
		return;
	}

}
