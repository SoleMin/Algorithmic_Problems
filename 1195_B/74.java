import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


public class Main {




    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader f = new BufferedReader(r);

        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong();
        long m=sc.nextLong();
        long sum=0;
        if(n==1){

        }else {
            for (long i = 1; i <= n; i++) {
                sum += i;
                if (sum - (n - i) == m) {
                    sum = n - i;
                    break;
                }
            }
        }
        System.out.println(sum);


    }
}
