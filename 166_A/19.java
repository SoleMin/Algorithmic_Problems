import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class C113A{
    static BufferedReader br;
    public static void main(String args[])throws Exception{
        br=new BufferedReader(new InputStreamReader(System.in));
        int nm[]=toIntArray();
        int n=nm[0];
        int k=nm[1];
        Pai p[]=new Pai[n];
        for(int i=0;i<n;i++){
            nm=toIntArray();
            p[i]=new Pai(nm[0],nm[1]);
        }
        Arrays.sort(p);
        int count=0;
        for(int i=0;i<n;i++){
            if(p[k-1].first==p[i].first && p[k-1].second==p[i].second){
                count++;
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
class Pai implements Comparable<Pai> {

    int first;
    int second;

    public Pai(int f, int s) {
        first = f;
        second = s;
    }

    public int compareTo(Pai p) {
        int ret = 0;
        if (first < p.first) {
            ret = 1;

        } else if (first > p.first) {
            ret = -1;

        } else {
            if(second<p.second){
                ret=-1;
            }
            else if(second>p.second){
                ret=1;
            }
            else ret=0;
        }
        return ret;
    }
}
