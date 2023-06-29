import java.io.*;
import java.util.*;

public class Lcm
{
public static void main(String args[])throws Exception
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
PrintWriter pw=new PrintWriter(System.out);
long n=Long.parseLong(br.readLine());
if(n<=2)
pw.println(n);
else
{

 if(n%6==0)
{
 pw.println(((n-1)*(n-2)*(n-3)));
}
 else if(n%2==0)
{
  pw.println((n*(n-1)*(n-3)));
}
else
{
  pw.println((n*(n-1)*(n-2)));
}
}
pw.flush();
}
}