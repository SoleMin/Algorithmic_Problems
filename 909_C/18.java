import java.util.*;
public class PythonIndentation {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int a[]=new int[t];
		int c=0;
		a[0]=1;
		long mod=(long) (1e9+7);
		sc.nextLine();
		for(int i=0;i<t;i++)
		{
			String s=sc.nextLine();
			if(s.equals("f"))
				c++;
			else
			{
				for(int j=1;j<=c;j++)
				{
					a[j]=(int) (((a[j]%mod)+(a[j-1]%mod))%mod);
				}
			}
		}
		
		System.out.println(a[c]);
		sc.close();
		
	}
}
