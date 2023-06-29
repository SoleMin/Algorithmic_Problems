import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
public class USACO {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine()," ");
        int[] perm = new int[n];
        int count=0;
        for (int i=0;i<n;i++) {
            perm[i]=Integer.parseInt(st.nextToken());
            for (int j=0;j<i;j++) {
                if (perm[j]>perm[i]) {
                    count++;
                }
            }
        }
        count=count%2;
        int m = Integer.parseInt(reader.readLine());
        for (int i=0;i<m;i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine()," ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            if ((b-a+1)%4==2||(b-a+1)%4==3) {
                count++;
                count=count%2;
            }
            if(count%2==0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }
}