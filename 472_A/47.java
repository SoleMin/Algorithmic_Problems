import java.util.*;
public class A
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		if(n % 2 == 1)
		{
			System.out.println(9 + " " + (n - 9));
		}
		else
		{
			System.out.println(4 + " " + (n - 4));
		}
	}
}
