
import java.util.*;
import java.math.*;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.Character.isDigit;

public class Main{
    static void debug(Object...os){
        System.err.println(deepToString(os));
    }
    int n,A;
    int[] bs,ls;
    void run(){
        n=nextInt();int k=nextInt();A=nextInt();
        bs=new int[n];ls=new int[n];
        for(int i=0;i<n;i++) {
            bs[i]=nextInt();ls[i]=nextInt();
        }
        dfs(k,0);
        System.out.println(res);
    }
    
    double res=0;
    private void dfs(int k,int i){
        if(i==n) {
            double val=0;
            for(int j=0;j<1<<n;j++) {// 1 approve
                double p=1;
                int B=0;
                for(int l=0;l<n;l++)p*= (j>>l&1)==1 ? ls[l]/100.0 : (100-ls[l])/100.0;
                for(int l=0;l<n;l++)if((j>>l&1)==0)B += bs[l];
                if(Integer.bitCount(j) > n/2) {
                    val += p;
                }else {
                    val += p * A / (A+B);
                }
            }
            res=max(res,val);
            return;
        }
        for(int j=0;j<k+1;j++) {
            ls[i]+=j*10;
            if(ls[i]<=100) {
                dfs(k-j,i+1);
            }
            ls[i]-=j*10;
        }
    }

    int nextInt(){
        try{
            int c=System.in.read();
            if(c==-1) return c;
            while(c!='-'&&(c<'0'||'9'<c)){
                c=System.in.read();
                if(c==-1) return c;
            }
            if(c=='-') return -nextInt();
            int res=0;
            do{
                res*=10;
                res+=c-'0';
                c=System.in.read();
            }while('0'<=c&&c<='9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }
    
    long nextLong(){
        try{
            int c=System.in.read();
            if(c==-1) return -1;
            while(c!='-'&&(c<'0'||'9'<c)){
                c=System.in.read();
                if(c==-1) return -1;
            }
            if(c=='-') return -nextLong();
            long res=0;
            do{
                res*=10;
                res+=c-'0';
                c=System.in.read();
            }while('0'<=c&&c<='9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }
    
    double nextDouble(){
        return Double.parseDouble(next());
    }
    
    String next(){
        try{
            StringBuilder res=new StringBuilder("");
            int c=System.in.read();
            while(Character.isWhitespace(c))
                c=System.in.read();
            do{
                res.append((char)c);
            }while(!Character.isWhitespace(c=System.in.read()));
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }
    
    String nextLine(){
        try{
            StringBuilder res=new StringBuilder("");
            int c=System.in.read();
            while(c=='\r'||c=='\n')
                c=System.in.read();
            do{
                res.append((char)c);
                c=System.in.read();
            }while(c!='\r'&&c!='\n');
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }
    public static void main(String[] args){
        new Main().run();
    }
}
