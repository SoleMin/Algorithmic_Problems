import java.io.*;
import java.math.*;
import java.util.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        new Main().run();
    }
    StreamTokenizer in;
    PrintWriter out;
    public void run() throws IOException
    {
        in =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
          out = new PrintWriter(new OutputStreamWriter(System.out));
        /*out = new PrintWriter(new FileWriter("output.txt"));
        in =new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));*/

        solve();

        out.flush();
    }

    public double nextInt() throws IOException
    {
        in.nextToken();
        return in.nval;
    }
    public void solve() throws IOException
    {
        double a=nextInt(),v=nextInt(),l=nextInt(),d=nextInt(),w=nextInt();
        double s=w*w/(2*a);
        if(s>d || w>v)
        {
        	double t=v*v/(2*a);
        	if(t>l)
        	{
        		double f=2*l/a;
        		out.print(String.format("%.10f",Math.sqrt(f)));
        		return;
        	}
        	double f=v/a;
        	double k=(l-t)/v;
        	out.print(String.format("%.10f",f+k));
        	return;
        }
        double t;
        if((2*v*v-w*w)/(2*a)<d)
        	t=v/a+(v-w)/a+(d-(2*v*v-w*w)/(2*a))/v;
        else
        {
        double v1=Math.sqrt((2*a*d+w*w)/2);
        t=v1/a+(v1-w)/a;
        }
        double r=l-d;
        double tr=(v*v-w*w)/(2*a);
        if(tr>r)
        {
        	double t1=(-w+Math.sqrt(w*w+2*a*r))/a;
        	out.print(String.format("%.10f",t+t1));
        	return;
        }
        r-=(v*v-w*w)/(2*a);
        t+=(v-w)/a;
        out.print(String.format("%.10f",t+r/v));
    }

}