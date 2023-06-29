import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemA {

    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String[] data = s.readLine().split(" ");
        int n =  Integer.valueOf(data[0]);
        int a =  Integer.valueOf(data[1]);
        int b =  Integer.valueOf(data[2]);

        long[] h = new long[n];
        String[] line = s.readLine().split(" ");
        for (int i = 0 ; i < n ; i++) {
            h[i] = Integer.valueOf(line[i]);
        }
        Arrays.sort(h);
        
        System.out.println(h[b] - h[b-1]);
    }
}