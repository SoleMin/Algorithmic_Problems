import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class A {
	
	
	static class team implements Comparable<team>
	{
		int problems;
		int penalty;
		public team(int problems,int penalty)
		{
			this.penalty=penalty;
			this.problems=problems;
		}
		public int compareTo(team a) {
			if (a.problems==this.problems)
				return this.penalty - a.penalty;
			return a.problems - this.problems;
		}
		
		public boolean igual(team a)
		{
			if (this.problems!=a.problems)
				return false;
			return (this.penalty==a.penalty);
		}
	}
	
	static class Scanner
	{
		BufferedReader rd;
		StringTokenizer tk;
		public Scanner() throws IOException
		{
			rd=new BufferedReader(new InputStreamReader(System.in));
			tk=new StringTokenizer(rd.readLine());
		}
		public String next() throws IOException
		{
			if (!tk.hasMoreTokens())
			{
				tk=new StringTokenizer(rd.readLine());
				return tk.nextToken();
			}
			return tk.nextToken();
		}
		public int nextInt() throws NumberFormatException, IOException
		{
			return Integer.valueOf(this.next());
		}
	}
	
	
	static team[] array=new team[100];
	static int N,K;
	
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner();
		N=sc.nextInt();
		K=sc.nextInt();
		for(int i=0;i<N;i++)
		{
			array[i]=new team(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(array,0,N);
		/*
		for(int i=0;i<N;i++)
			System.out.println(array[i].problems);*/
		
		int shared=0;
		for(int i=K-1;i>=0 && array[K-1].igual(array[i]);i--,shared++);
		for(int i=K;i<N && array[K-1].igual(array[i]);i++,shared++);
		System.out.println(shared);
	}

}