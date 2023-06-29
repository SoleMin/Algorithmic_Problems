import java.util.Scanner;

public class CF{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		TaskA t = new TaskA();
		System.out.println(t.solve(n));
	}
}

class TaskA{
	public long solve(long n)
	{
		if(n < 3)
			return n;
		else if(n % 2 == 1)
			return n * (n-1) * (n-2);
		else if(n % 3 != 0)
			return n * (n-1) * (n-3);
		else
			return (n-1) * (n-2) * (n-3);
	}
}