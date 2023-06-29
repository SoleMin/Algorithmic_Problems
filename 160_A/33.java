import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author codeKNIGHT
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt(),i,sum=0;
        int a[]=new int[n];
        for(i=0;i<n;i++)  {

            a[i]=in.nextInt();
            sum+=a[i];
        }
        Arrays.sort(a);
        int s=0,c=0;
        for(i=n-1;i>=0;i--)
        {
            if(s>sum)
                break;
            s+=a[i];
            sum-=a[i];
            
                        c++;
        }
        out.println(c);
	}
}

