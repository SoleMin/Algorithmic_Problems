import java.io.*;
import java.util.*;

public class lucky
{ 
   public static void main(String args[]) throws IOException
   { 
    BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
    
    String s=cin.readLine();
    int l=s.length();
    int n=Integer.parseInt(s);
    if(s.equals("47") || s.equals("4") || s.equals("7") || s.equals("74") || s.equals("447") || s.equals("477") || s.equals("474") || s.equals("44") || s.equals("77") || s.equals("444") || s.equals("777") || s.equals("747") || s.equals("774") || s.equals("744"))
          
          System.out.println("YES");
    else if(n%(47)==0 || n%(4)==0 || n%(7)==0 || n%(74)==0 || n%(447)==0 || n%(477)==0 || n%(474)==0 || n%(44)==0 || n%(77)==0 || n%(444)==0 || n%(777)==0  || n%(747)==0  || n%(774)==0  || n%(744)==0)
            System.out.println("YES");
    else
            System.out.println("NO");
            }
 }          