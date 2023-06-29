
import java.util.*;


public class B
{
   public static void main(String[] args)
   {
      new B(new FastScanner());
   }

   int hash(int i, int[] cc)
   {
      int res = i;
      for (int ii : cc)
      {
         res *= 8;
         res += ii;
      }

      return res;
   }

   int N, K, A;
   int[] lvl;
   int[] vs; // loyalty

   
   double calc(int i, int[] cc)
   {
      // Find the probability of winning
      double res = 0;

      int cnt = 0;
      for (int m=0; m<1<<N; m++)
      {
         double pt = 1.0;
         boolean passed = true;
         int nG = 0;
            
         int lvlcnt = 0;
         for (int j=0; j<N; j++)
         {
            int p = 10*cc[j]+vs[j];
            int u = m&(1<<j);

            boolean votesGood = (u > 0);
            if (votesGood)
               nG++;
            else
               lvlcnt += lvl[j];
               
            if ((p == 0)&&(votesGood))
               passed = false;
            if ((p == 100)&&(!votesGood))
               passed = false;
            if (!passed)
               break;

            if (votesGood)
               pt *= (p/100.0);
            else
               pt *= ((100-p)/100.0);
         }

         if (passed == false)
            continue;
         
         if (2*nG <= N)
         {
            // Calculate if we kill all senators
            double p1 = A/(1.0*(A+lvlcnt));
            
            // Add in the probability of losing
            res += (1-p1)*pt;
         }
      }

      return 1.0-res;
   }

   HashMap<Integer, Double> memo;
   double go(int i, int[] cc)
   {
      if (i == -1)
         return calc(i, cc);

      int hv = hash(i, cc);
      Double rr = memo.get(hv);
      if (rr != null)
         return rr;

      double res = go(i-1, cc);
      for (int j=0; j<N; j++)
      {
         int cv = vs[j]+cc[j]*10;
         if (cv == 100)
            continue;

         cc[j]++;
         double rrr = go(i-1, cc);
         cc[j]--;
         
         if (rrr > res)
            res = rrr;
      }
      
      memo.put(hv, res);
      return res;
   }

   public B(FastScanner in)
   {
      N = in.nextInt();
      K = in.nextInt();
      A = in.nextInt();
      memo = new HashMap<Integer, Double>();

      lvl = new int[N];
      vs = new int[N];
      for (int i=0; i<N; i++)
      {
         lvl[i] = in.nextInt();
         vs[i] = in.nextInt();
      }

      int[] cs = new int[8];
      double res = go(K-1, cs);
      System.out.printf("%.10f%n", res);
   }
}


class FastScanner{
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
}
