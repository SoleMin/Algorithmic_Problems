import java.io.*;
import java.math.*;
import java.util.*;
public class Main{
  public static void main(String[] args){
    InputReader reader = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int n = reader.nextInt();
    int r = reader.nextInt();
    int[] x = new int[n];
    double[] y = new double[n];
    
    for(int i=0;i<n;++i){
      int iniX = reader.nextInt();
      double bestY = (double)r;
      for(int j=0;j<i;++j){
//         pw.printf("testing %d %d\n", i, j);
        if(Math.abs(iniX - x[j]) < 2*r){
//           pw.printf("on colision %d %d\n", i, j);
          bestY = Math.max(bestY, collisionY((double)x[j], y[j], (double)iniX, r));
        }
        if(Math.abs(iniX - x[j]) == 2*r){
//           pw.printf("touvhing %d %d\n", i, j);
          bestY = Math.max(bestY, y[j]);
        }
      }
      x[i] = iniX;
      y[i] = bestY;
    }
    for(int i=0;i<n;++i){
      pw.printf("%.9f ", y[i]);
    }   
    pw.flush();
    pw.close();
  }
  
  public static double collisionY(double x1, double y1, double x2, double r){
    double dhsq = r*r*4-(x1-x2)*(x1-x2);
    return y1+Math.sqrt(dhsq);
  }
  
  public static class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;
    
    public InputReader (InputStream stream){
      reader = new BufferedReader(new InputStreamReader(stream));
    }
    

    public String next(){
      while(tokenizer == null || !tokenizer.hasMoreTokens()){
        try{
          String line = reader.readLine();
          if(line == null){
            return "0";
          }
          tokenizer = new StringTokenizer(line);
        } catch(IOException ioe){
          throw new RuntimeException(ioe);
        }
      }
      return tokenizer.nextToken();
    }
    
    public int nextInt(){
      return Integer.parseInt(next());
    }
    
    public double nextDouble(){
      return Double.parseDouble(next());
    }
    
    public Long nextLong(){
      return Long.parseLong(next());
    }
    
    public BigInteger nextBigInteger(){
      return new BigInteger(next());
    }
    
    public String nextLine(){
      String line = "";
      try{
        while(line.equals("")){
          line = reader.readLine();
        }
      } catch(IOException ioe){
        throw new RuntimeException(ioe);
      }
      return line;
    }
  }
  
  public static class MultiSet<E> {
    HashMap<E, Integer> map = new HashMap<E, Integer>();
    int multiSize = 0;
    public int add(E key){
      multiSize ++;
      Integer amount = map.get(key);
      if(amount == null){
        map.put(key, 1);
        return 1;
      }
      map.put(key, amount+1);
      return amount+1;
    }
    
    public int remove(E key){
      Integer amount = map.get(key);
      if(amount == null){
        return -1;
      }
      multiSize --;
      if(amount == 1){
        map.remove(key);
      } else {
        map.put(key, amount-1);
      }
      return amount-1;
    }
    
    public ArrayList<E> elems(){
      ArrayList<E> ret = new ArrayList<E>(multiSize);
      for(Map.Entry<E, Integer> e : map.entrySet()){
        E key = e.getKey();
        int v = e.getValue();
        while(v-->0){
          ret.add(key);
        }
      }
      return ret;
    }
    
    public int getMultiSize(){
      return multiSize;
    }
  
  }
  
  
   public static class MaxBIT{
    int n;
    int[]t;
    
    public MaxBIT(int n){
      this.n = Integer.highestOneBit(n)<<1;
      this.t = new int[this.n<<1];
      for(int i=0;i<2*this.n;++i){
        t[i] = -1;
      }
    }
  
    public void setMax(int p, int val){
      p+=n;
      while(p>1){
        t[p] = Math.max(t[p], val);
        p>>=1;
      }
    }
    
    public int getMax(int p, int q){
      p+=n;
      q+=n;
      int ret = -1;
      while(p<q){
        if((p&1)==1){
          ret=Math.max(t[p++], ret);
        }
        if((q&1)==1){
          ret=Math.max(t[--q], ret);
        }
        p = p>>1;
        q = q>>1;
      }
      return ret;
    }
  }
  
}