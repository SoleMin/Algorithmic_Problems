import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        
        int n = Integer.parseInt(st.nextToken()),
            a = Integer.parseInt(st.nextToken()),
            b = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(in.readLine());
        
        ArrayList<Integer> A = new ArrayList<Integer>();
        
        for (int i = 0 ; i < n ; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(A);
        
        System.out.println(A.get(b) - A.get(b - 1));
    }
}
