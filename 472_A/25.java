import java.util.*;
	
public class A {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		
		if (n % 2 == 0)
			System.out.print("4 " + (n-4));
		else 
			System.out.print("9 " + (n-9));
	}
}
