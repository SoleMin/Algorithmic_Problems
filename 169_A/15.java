import java.io.*;
import java.util.*;

public class test
{

	public static void main(String[] args)
	{
		new test().run();
	}

	PrintWriter out = null;

	void run()
	{
		Scanner in = new Scanner(System.in);
		out = new PrintWriter(System.out);

		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();

		int[] h = new int[n];
		for (int i = 0; i < n; i++)
			h[i] = in.nextInt();

		Arrays.sort(h);

		if (h[b] == h[b - 1])
			out.println(0);
		else
			out.println(h[b] - h[b - 1]);
		out.close();
	}
}
