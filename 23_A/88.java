import java.io.*;
import java.math.BigInteger;

public class Main {
	BufferedReader in;
	PrintWriter out;
	
	public static void main(String[] args) throws IOException
	{
		new Main().run();
	}
	public void run() throws IOException
	{
		//in=new BufferedReader(new FileReader("input.txt"));
		//out=new PrintWriter(new FileWriter("output.txt"));
		in=new BufferedReader(new InputStreamReader(System.in));
		out=new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		
		out.flush();
	}

	public void solve() throws IOException
	{
		String now=in.readLine();
		int l=now.length();
		int answ=0;
		for(int i=0;i!=l;i++)
			for(int j=i+1;j<l;j++)
			{
				String a=now.substring(i, j);
				for(int k=i+1;k<l-j+i+1;k++)
					if(a.compareTo(now.substring(k, k+j-i))==0)
						answ=Math.max(answ, a.length());
			}
		out.print(answ);
		
		
	}
}
