import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class C111A{
    static BufferedReader br;
    public static void main(String args[])throws Exception{
        br=new BufferedReader(new InputStreamReader(System.in));
        int n = toInt();
        int nm[] = toIntArray();
        double a=0.0;
        double sum=0;
        for(int i=0;i<n;i++){
            sum+=nm[i];
        }
        a=sum/2;
        Arrays.sort(nm);
        int cur=0;
        int count=0;
        for(int i=nm.length-1;i>=0;i--){
            cur+=nm[i];
            count++;
            if(cur>a){
                break;
            }
        }
        System.out.println(count);


    }


    /****************************************************************/
    public static int[] toIntArray()throws Exception{
       String str[]=br.readLine().split(" ");
       int k[]=new int[str.length];
       for(int i=0;i<str.length;i++){
            k[i]=Integer.parseInt(str[i]);
       }
       return k;
    }
    public static int toInt()throws Exception{
       return Integer.parseInt(br.readLine());
    }
    public static long[] toLongArray()throws Exception{
       String str[]=br.readLine().split(" ");
       long k[]=new long[str.length];
       for(int i=0;i<str.length;i++){
            k[i]=Long.parseLong(str[i]);
       }
       return k;
    }
    public static long toLong()throws Exception{
       return Long.parseLong(br.readLine());
    }
    public static double[] toDoubleArray()throws Exception{
       String str[]=br.readLine().split(" ");
       double k[]=new double[str.length];
       for(int i=0;i<str.length;i++){
            k[i]=Double.parseDouble(str[i]);
       }
       return k;
    }
    public static double toDouble()throws Exception{
       return Double.parseDouble(br.readLine());
    }
    public static String toStr()throws Exception{
       return br.readLine();
    }
    public static String[] toStrArray()throws Exception{
       String str[]=br.readLine().split(" ");
       return str;
    }
    /****************************************************************/

}
