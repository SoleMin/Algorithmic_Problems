import java.awt.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
public class Main3 {
    static PrintWriter pr;
    static Scanner scan;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String args[]) throws Exception {
        pr = new PrintWriter(System.out);
        scan = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = inputInt();
        //char[] c = br.readLine().toCharArray();
        int[] a = new int[n];
        int[] b = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){

            a[i]=Integer.parseInt(st.nextToken());
            //b[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int ans=0;
        for(int i=0;i<n;i++){
            if(b[i]!=1){
                ans++;
                for(int j=i;j<n;j++){
                    if(a[j]%a[i]==0){
                        b[j]=1;
                    }
                }
            }
        }
        System.out.println(ans);
    }


    public static int inputInt() throws IOException{
        return Integer.parseInt(br.readLine());
    }

    public static long inputLong() throws IOException{
        return Long.parseLong(br.readLine());
    }

    public static String inputString() throws IOException{
        return br.readLine();
    }

    public static  int[] intArray(int n) throws IOException{
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        return a;
    }

    public static  long[] longArray(int n) throws IOException{
        long a[] = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        return a;
    }

    public static String[] stringArray(int n) throws IOException{
        String a[] = new String[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = st.nextToken();
        }
        return a;
    }

    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }

    public long max(long a,long b,long c){
        return Math.max(a,Math.max(b,c));
    }
}