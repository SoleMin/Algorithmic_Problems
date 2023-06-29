import java.util.*;
import java.io.*;
 
public class Main
{
	static int n,k;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		char[][] grid = new char[4][n];
		for(int i=0;i<4;i++)
			Arrays.fill(grid[i], '.');
		if(k%2==0) 
		{
			int j = 1;
			while(k>0)
			{
				k-=2;
				grid[1][j]=grid[2][j] = '#';
				j++;
			}
		}
		else
		{
			int mid = n/2;
			grid[1][mid] = '#';
			k--;
			for(int d=1;d<n/2 && k>0;k-=2,d++)
				grid[1][mid+d] = grid[1][mid-d] = '#';
			for(int d=1;d<n/2 && k>0;k-=2,d++)
				grid[2][mid+d] = grid[2][mid-d] = '#';
		}
		System.out.println("YES");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(grid[i][j]);
			System.out.println();
		}
	}
}
 