import java.io.*;
import java.util.*;

public class Main {

    StreamTokenizer in;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        Locale.setDefault(Locale.US);
        in = new StreamTokenizer (new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }
    
    public int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }
    
    public String next() throws Exception {
        in.nextToken();
        return in.sval;
    }
    
    class Senator {
        int b;
        int l;
        
        public Senator (int b,int l) {
            this.b=b;
            this.l=l;
        }
        
    }
    
    int n,k,A;
    double max=Integer.MIN_VALUE;
    Senator[] a;
    
    public void check (int step,int candy) {
        if (step==n)
        {
            double tmp = 0.0;
            for (int mask=0; mask<(1<<n);mask++)
            {
                double P = 1.0;
                int q = 0;
                for (int i=0; i<n;i++)
                {
                    if ((mask>>i&1)!=0)
                    {
                        P*=a[i].l/100.;
                    } else
                    {
                        P*=1.0-a[i].l/100.;
                        q+=a[i].b;
                    }
                }
                if (Integer.bitCount(mask)>n/2)
                {
                    tmp+=P;
                } else
                {
                    tmp+=P*A/(A+q);
                }
                max=Math.max(tmp,max);
            }
        } else
        {
            for (int i=0;i<=Math.min(k,(100-a[step].l)/10);i++)
            {
                a[step].l+=10*i;
                check(step+1,k-i);
                a[step].l-=10*i;
            }
        }
    }
    
    public void solve() throws Exception {
        n=nextInt();
        k=nextInt();
        A=nextInt();
        a = new Senator [n];
        for (int i=0; i<n;i++) {
            Senator q = new Senator(nextInt(),nextInt());
            a[i]=q;
        }
        double ans=0;
        for(int mask=0;mask<1<<(n+k-1);mask++)
        {
            if(Integer.bitCount(mask)!=k) continue;       
            int[] b = new int[n];
            int x = mask;
            for(int i=0;i<n;i++)
            {
                b[i] = a[i].l;
                while(x%2==1)
                {
                    b[i]+=10;
                    x/=2;
                }
                b[i]=Math.min(b[i],100);
                x/=2;
            }
            double tmp=0;
            for(int w=0; w<(1<<n);w++)
            {
                double p = 1.;
                double B = 0;
                for(int i = 0; i < n; i++)
                    if((w >> i & 1) != 0) p *= b[i] / 100.;
                    else
                    { 
                        p *= 1- b[i]/100.;
                        B += a[i].b;
                    }
                if(Integer.bitCount(w)> n/2) tmp += p;
                else tmp += p * (A / (A + B));
            }
            ans = Math.max(ans, tmp);
        }
        out.printf("%.10f\n", ans);
    }
}