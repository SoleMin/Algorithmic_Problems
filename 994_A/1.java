import java.util.*;
import java.io.*;
public final class Codeforces{
    public static BufferedReader buffer=new BufferedReader(
                                            new InputStreamReader(System.in)
                                        );
    public static BufferedWriter logger=new BufferedWriter(
                                            new OutputStreamWriter(System.out)
                                        );
    public static void main(String[] args){
        try{
            args=buffer.readLine().split(" ");
            int n=Integer.parseInt(args[0]);
            int m=Integer.parseInt(args[1]);
            args=buffer.readLine().split(" ");
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(args[i]);
            }
            args=buffer.readLine().split(" ");
            boolean tip[]=new boolean[10];
            for(int i=0;i<m;i++){
                tip[Integer.parseInt(args[i])]=true;
            }
            for(int i=0;i<n;i++){
                if(tip[a[i]]){
                    logger.write(a[i]+" ");
                }
            }
            logger.flush();
        }
        catch(IOException exc){}
    }
}