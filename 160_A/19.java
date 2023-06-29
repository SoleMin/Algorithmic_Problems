//coded by : ariefianto17 | Reza Ariefianto

import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	public static void main (String[]args)
	{
		Scanner read = new Scanner (new BufferedInputStream (System.in));
		int n = read.nextInt();
		int[]arr = new int[n];
		int sum=0;
		int sum2=0;
		int coin=0;
		for(int i=0;i<n;i++)
		{
			arr[i] = read.nextInt();
			sum+=arr[i];
		}
		Arrays.sort(arr);
		for(int i=n-1;i>=0;i--)
		{
			sum2+=arr[i];
			sum-=arr[i];
			coin++;
			if(sum2>sum)
				break;

		}
		System.out.println(coin);
	}
}