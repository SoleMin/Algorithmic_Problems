import java.io.*;
import java.util.*;
import java.math.*;

public class Codeforces
{
  public StreamTokenizer st;
  public PrintWriter pw;
  public static final int modulo = 1000000009; 
  
  static class Point
  {
    public int x, y;
    Point(int _x, int _y)
    {
      x = _x;
      y = _y;
    }
  }
  
  void init(String in, String out) 
  {
    if (in.isEmpty())
      st = new StreamTokenizer(System.in);
    else
    {
      try
      {
        st = new StreamTokenizer(new BufferedReader(new FileReader(in)));
      }
      catch(FileNotFoundException e)
      {
        
      }
    }
    
    if (out.isEmpty())
      pw = new PrintWriter(System.out);
    else
    {
      try
      {
        pw = new PrintWriter(new FileWriter(out));
      }
      catch(IOException e)
      {
        
      }
    }
  }
  
  private void close()
  {
    pw.close();
  }
  
  private int nI()
  {
    try{
      st.nextToken();
    }
    catch(IOException e)
    {
      
    }
    return (int)st.nval;
  }
  
  private double nD()
  {
    try{
      st.nextToken();
    }
    catch(IOException e)
    {
      
    }
    return st.nval;
  }
  
  private String nS()
  {
    try{
      st.nextToken();
    }
    catch(IOException e)
    {
      
    }
    return st.sval;
  }
   
  private long nL()
  {
    try{
      st.nextToken();
    }
    catch(IOException e)
    {
      
    }
    return (long)st.nval;
  }
  
  public static void qSort(int[] A, int low, int high) {
    int i = low;                
    int j = high;
    int x = A[(low+high)/2];  
    do {
        while(A[i] < x) ++i;  
        while(A[j] > x) --j;  
        if(i <= j){           
            
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
       
            i++; j--;
        }
    } while(i < j);
    if(low < j) 
      qSort(A, low, j);
    if(i < high) 
      qSort(A, i, high);
    
}
  
  public static void main(String[] aslkdjlkgja) throws IOException
  {
    Codeforces z = new Codeforces();
    z.init("", "");
   
    long l = z.nL();
    long r = z.nL();
    if ( l == r)
    {
      System.out.println(0);
      z.close();
      return;
    }
    
    List<Boolean> R = new ArrayList<Boolean>();
    List<Boolean> L = new ArrayList<Boolean>();
    
    long temp = r;
    while (temp != 0)
    {
      if (temp % 2 == 1)
        R.add(true);
      else
        R.add(false);
      temp /= 2;
    }
    
    Collections.reverse(R);
    
    temp = l;
    while (temp != 0)
    {
      if (temp % 2 == 1)
        L.add(true);
      else
        L.add(false);
      temp /= 2;
    }    
    
    int n = R.size() - L.size();
    while (n!=0)
    {
      L.add(false);
      --n;
    }
    Collections.reverse(L);
    
    List<Boolean> res = new ArrayList<Boolean>();
   // for (int i = 0 ; i < R.size(); ++i)
     // res.add(false);
    
    int it = 0;
    
    while (R.get(0) == L.get(0))
    {
      res.add(false);
      R.remove(0);
      L.remove(0);
    }
    
    for (int i = 0; i< R.size(); ++i)
      res.add(true);
    
    long out = 0;
    it = 0;
    long add = 1;
    Collections.reverse(res);
    while (it < res.size())
    {
      if (res.get(it))
        out += add;
      add *= 2;
      ++it;
    }
    System.out.println(out);
  }
  
  
  
}