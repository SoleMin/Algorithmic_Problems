import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        long l = 0;
        long r = n;
        while(l <= r){
            long min = (l + r) / 2;
            if((min * (min + 1) / 2 - (n - min) == k)){
                System.out.println(n - min);
                return;
            }
            else if((min * (min + 1) / 2 - (n - min) > k)){
                r = min - 1;
            }
            else{
                l = min + 1;
            }
        }
    }
}