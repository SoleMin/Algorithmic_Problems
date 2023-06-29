import java.io.*;
import java.util.*;

public class test{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            if(n>=0) {
                System.out.println(n);
                return;
            }else {
                int p = n/10;
                int q = -1*(-1*n/100)*10+(n%10);
                System.out.println(Math.max(p, q));
            }
        } catch (Exception e) {
            return;
        }
    }
}