import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Mirza
 * Date: 25.03.12
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
public class main {
        static Scanner in; static int next() throws Exception {return in.nextInt();};
    //static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}
    //  static BufferedReader in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
//      in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//      in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int n = next();
        int a = next();
        int b = next();
        int k = 0;
        int i;
        int[] ar = new int[n];
        for(i=0;i<n;i++)
            ar[i]=next();
        Arrays.sort(ar);
        k = ar[n-a]-ar[b-1];
        if(k<0)
            out.print(0);
        else out.print(k);
        out.close();

    }
}