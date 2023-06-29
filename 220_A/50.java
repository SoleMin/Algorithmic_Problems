import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * User: serparamon
 */
public class Codeforces_2012_08_31_A {

    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        in.nextToken();
        int n = (int) in.nval;
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(a);
        int k = 0;
        for (int i=0; i<n; i++) {
            if (a[i] != b[i]) k++;
        }
        if (k==0 || k==2)
            out.println("YES");
        else
            out.println("NO");
        out.flush();
        out.close();
    }

}
