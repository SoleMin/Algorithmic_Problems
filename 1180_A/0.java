// Dummy text
import java.io.*; 
import java.util.*; 
  public class forgery
  {  
    public static void main(String[] args) throws IOException 
    { 
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           int n=Integer.parseInt(br.readLine());
          long answer=0;
          if(n==1)
          answer=1;
          else
          answer= 2*n*n-2*n+1;
          System.out.println(answer);
 }
  }