import java.io.*;
class Main 
{
	public static void computeNext(String p, int [] next)
	{
		int m = p. length();
		next[0] = 0;
		int k = 0;
		int q = 1;
		for (q=1; q< m; q++)
		{
				while (k > 0 && p.charAt(k) != p.charAt(q))
					k = next[k-1];
			if (p.charAt(k) == p.charAt(q))
				next[q] = ++ k;
		}
	}
	public static void KMP (String t, String p)
	{
		int lenT = t.length();
		int lenP = p.length();
		int next[] = new int [lenP];
		int match[] = new int [lenT];
		int matches = 0;
		computeNext (p, next);
		int i = 0;
		int q = 0;
		for (i = 0; i < lenT; i++)
		{
			while (q > 0 && p.charAt(q) != t.charAt(i))
				q = next[q-1];
			if (p.charAt(q) == t.charAt(i))
			{
				if (q == lenP -1)
				{
					match[matches++] = (i - lenP + 2);
					q = next[q];
				}
				else q++;
			}
		}
		System.out.println(matches);
		for (i = 0; i < matches; i++)
			System.out.print(match[i] + " ");
	}
	public static void main(String[] args) throws Exception 
	{
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		String t = input.readLine();
		String p = input.readLine();
		KMP(t, p);
		input.close();
	}
}