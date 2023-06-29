import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    StreamTokenizer in;
    PrintWriter out;
    public static void main(String[] args) throws IOException
    {
        new Main().run();
    }
    public void run() throws IOException
    {
    //	in =new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
    //  out = new PrintWriter(new FileWriter("output.txt"));

        in =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	   out = new PrintWriter(new OutputStreamWriter(System.out));
             solve();
        out.flush();
        
    }
    public int nextInt() throws IOException
    {
        in.nextToken();
        return (int) in.nval;
    }
    boolean pr(int i)
    {
    	if(i<4) return true;
    	for(int j=2;j<Math.sqrt(i)+1;j++)
    		if(i%j==0)
    			return false;
    	return true;
    }
    public void solve() throws IOException
    {
    	int n=nextInt(),k=nextInt();
    	int prost[]=new int[1000];
    	boolean now[]=new boolean[10000];
    	int a=0;
    	for(int i=2;i!=1000;i++)
    		if(pr(i))
    			prost[a++]=i;
    	for(int i=0;i!=a-1;i++)
    	{
    		if(pr(prost[i]+prost[i+1]+1))
    			now[prost[i]+prost[i+1]+1]=true;
    	}
    	int answ=0;
    	for(int i=0;i!=n+1;i++)
    		if(now[i])
    			answ++;
    	if(answ>=k)
    		out.print("YES");
    	else
    		out.print("NO");
    }

}