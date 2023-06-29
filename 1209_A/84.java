import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		
		Arrays.sort(arr);
		
		int[] visited=new int[n];
		
		int ans=0;
		
		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
			{	
				ans++;
				
				for(int j=i+1;j<n;j++)
				{
					if(arr[j]%arr[i]==0&&visited[j]==0)
					{
						visited[j]=1;
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
}