import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class VkR2A{
    static BufferedReader br;
    public static void main(String args[])throws Exception{
        br=new BufferedReader(new InputStreamReader(System.in));

        int nm[] = toIntArray();
        int n = nm[0];
        int a = nm[1];
        int b = nm[2];
        nm=toIntArray();
        Arrays.sort(nm);
        int k=nm[b-1];
        int res=nm[b]-k;
        System.out.println(res);

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
