import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int r=nextInt();
        int x[]=new int[n];
        double y[]=new double[n];
        for(int i=0;i<n;i++)
            x[i]=nextInt();
        for(int i=0;i<n;i++){
            //(x1-x2)2+(y1-y2)2=r2
            y[i]=r;
            for(int j=0;j<i;j++){
                int d=sq(2*r)-sq(x[i]-x[j]);
                if(d>=0){
                    double y1=Math.sqrt(d)+y[j];
                    y[i]=Math.max(y1,y[i]);
                }
            }
        }
        for(int i=0;i<n;i++)
            System.out.printf("%.12g ",y[i]);
    }
    static int sq(int a){
        return a*a;
    }
    static int nextInt()throws IOException{
        InputStream in=System.in;
        int ans=0;
        boolean flag=true;
        byte b=0;
        while ((b>47 && b<58) || flag){
            if(b>=48 && b<58){
                ans=ans*10+(b-48);
                flag=false;
            }
            b=(byte)in.read();
        }
        return ans;
    }
    static String next()throws Exception{
        StringBuilder sb=new StringBuilder(1<<16);
        InputStream in=System.in;
        byte b=0;
        do{
            if(!isWhiteSpace(b))
                sb.append((char)b);
            b=(byte)in.read();
        }while(!isWhiteSpace(b) || sb.length()==0);
        return sb.toString();
    }
    static boolean isWhiteSpace(byte b){
        char ch=(char)b;
        return ch=='\0' || ch==' ' || ch=='\n';
    }
}