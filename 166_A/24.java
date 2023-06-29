
import java.util.Arrays;
import java.util.Scanner;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n  = scan.nextInt();
		int k = scan.nextInt()-1;
		team[] t = new team[n];
		for(int i = 0 ;i  < n ; i++)
			t[i] = new team(scan.nextInt(), scan.nextInt());
		Arrays.sort(t);
		int a =0;
		int b = 0;
		while(k+a < t.length-1 && t[k+a+1].compareTo(t[k]) == 0)
			a++;
		while(k-b > 0 && t[k-b-1].compareTo(t[k]) == 0)
			b++;
		System.out.println(a+b+1);
	}

}
class team implements Comparable<team>
{
	int p;
	int t;
	public team(int pp , int tt)
	{
		p = pp;
		t= tt;
	}
	@Override
	public String toString()
	{
		return p+" "+t;
	}
	@Override
	public int compareTo(team e)
	{
		int a = e.p-p;
		if(a == 0)
		{
			return  t-e.t;
		}else
			return a;
	}
}