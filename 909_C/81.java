import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        solve(System.in,System.out);

    }

    static void solve(InputStream inStream, PrintStream printStream) {
        Scanner in = new Scanner(inStream);
        int n = in.nextInt();
        long[] sums = new long[n];
        for (int i = 1; i < n; i++) {
            sums[i]=0;
        }
        sums[0]=1;

        long mod = 1000000007;

        for (int i = 0; i < n; i++) {
            if (in.next().equals("f") ) {
                for (int j = n-1; j > 0 ; j--) {
                    sums[j]=sums[j-1];
                }
                sums[0]=0;
            } else {
                for (int j = n-2; j >= 0 ; j--) {
                    sums[j] += sums[j+1];
                    if (sums[j]>=mod) {
                        sums[j]-=mod;
                    }
                }
            }
        }

//        long finalSum = 0;
//        for (int i = 0; i < n; i++) {
//            finalSum+=sums[i];
//        }

        printStream.println(sums[0]);

    }



}
