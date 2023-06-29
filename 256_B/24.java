import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;


public class D {

    static long n;
    static long x;
    static long y;
    static long c;
    static long f(long t){
        long s=0;
        if(t==0)
            s=1;
        else{
            s=(4+4*t)/2*t+1;
        }
        if(x+t>n){
            long c=x+t-n;
            s-=c*c;
        }
        if(x-t<=0){
            long c=t-x+1;
            s-=c*c;
        }
        if(y+t>n){
            long c=y+t-n;
            s-=c*c;
        }
        if(y-t<=0){
            long c=t-y+1;
            s-=c*c;
        }
        if(t>x+y-1){
            long m=t-x-y+1;
            s+=m*(m+1)/2;
        }
        if (t>x+n-y) {
            long m=t-x-n+y;
            s+=m*(m+1)/2;
        }
        if (t>n-x+y) {
            long m=t-n-y+x;
            s+=m*(m+1)/2;
        }
        if (t>n-x+n-y+1) {
            long m=t-2*n+x+y-1;
            s+=m*(m+1)/2;
        }
        return s;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        n=in.nextLong();
        x=in.nextLong();
        y=in.nextLong();
        c=in.nextLong();
        
        
        
        
        long l=0;
        long r=2*n;
        while(l<r){
            long m=(l+r)/2;
            long ff=f(m);
            if(ff<c){
                l=m+1;
            }
            else{
                r=m;
            }
        }
        out.println(l);
        out.close();
    }

}