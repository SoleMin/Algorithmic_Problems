import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String str[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(
                new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            if((n%2==0 && Math.pow(n/2,0.5)%1.0==0) || (n%4==0 && Math.pow(n/4,0.5)%1.0==0) )  output.write("YES\n");
            else {
                output.write("NO\n");
            }
        }
        output.flush();
    }

}

