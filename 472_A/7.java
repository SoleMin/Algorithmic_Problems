import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.lang.Integer.*;

public class A {

    public static void main(String[] args) throws IOException {
        //BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner (System.in);
    //  StringTokenizer st=new StringTokenizer(buf.readLine());
        int n=sc.nextInt();
        System.out.println(n%2==0?4+" "+(n-4):9+" "+(n-9));

    }

}
