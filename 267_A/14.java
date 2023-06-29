
import java.util.Scanner;

public class Sub
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int noOfPairs=scan.nextInt();
		while(noOfPairs-->0)
		{
			int x=scan.nextInt();
			int y=scan.nextInt();
			int res=0;
			while(x!=0&&y!=0)
			{
			  if(x>y) 
			   {
				res+=x/y;
				x=x%y;
			   }
			  else 
			   {
				  res+=y/x;
				  y=y%x;
			   }
			}
			System.out.println(res);
		}
		scan.close();
	}
}
