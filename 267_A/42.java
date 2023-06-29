import java.util.*;
public class subtractionn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t;
		t=in.nextInt();
		while(t!=0)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			int total=0,neww=0;
			if(a%b==0)
			{
				System.out.println(a/b);
			}
			else if(b%a==0)
			{
				System.out.println(b/a);
			}
			else
			{
			while(a!=0 && b!=0)
			{
				if(a>b)
				{
					total=total+(a/b);
					a=a%b;
					if(a==0)
					{
						break;
					}
				}
				else if(b>a)
				{
					total=total+(b/a);
					b=b%a;
					if(b==0)
					{
						break;
					}
				}
				else
				{
					System.exit(0);
				}
			}
			System.out.println(total);
			}
		t--;
		}
	}
}