
import java.io.*;
import java.math.*;
import static java.lang.Math.*;
import java.security.SecureRandom;
import static java.util.Arrays.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.Regexp;
import java.awt.geom.*;
import sun.net.www.content.text.plain;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    StreamTokenizer in;
    PrintWriter out;
//deb////////////////////////////////////////////////

    public static void deb(String n, Object n1) {
        System.out.println(n + " is : " + n1);
    }

    public static void deb(int[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(boolean[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(double[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(String[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }

    public static void deb(double[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }

    public static void deb(long[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }

    public static void deb(String[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }
    /////////////////////////////////////////////////////////////

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    void run() throws IOException {
//          in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
        // out = new PrintWriter(new FileWriter("output.txt"));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }
//boolean inR(int x,int y){
//return (x<=0)&&(x<4)&&(y<=0)&&(y<4);
//}
    @SuppressWarnings("unchecked")
    void solve() throws IOException {
        //   BufferedReader re= new BufferedReader(new FileReader("C:\\Users\\ASELA\\Desktop\\PROBLEMSET\\input\\F\\10.in"));
           BufferedReader re= new BufferedReader(new InputStreamReader(System.in));
     Scanner sc= new Scanner(System.in);
     long n=sc.nextLong(),k=sc.nextLong();
     if(k*(k-1)/2<n-1)
            System.out.println("-1");
     else{
     long ff=k*(k-1)/2;
     ff=-2*(n-1-ff);
     //    System.out.println(ff);
    long up=k,dw=0;
    while(up-dw>1){
    long c=(up+dw)/2;
    if(c*(c-1)<=ff)dw=c;
    else up=c;
    
    }
    if(n==1)
    {   System.out.println("0");
    return;
    }
         System.out.println(k-dw);
     }
    }
}
