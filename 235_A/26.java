import java.io.*;
import java.util.*;

public class Lcm
{
public static void main(String args[])throws Exception
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

long n=Long.parseLong(br.readLine());
if(n<=2)
System.out.println(n);
else
{

 if(n%6==0)
{
 System.out.println(((n-1)*(n-2)*(n-3)));
}
 else if(n%2==0)
{
  System.out.println((n*(n-1)*(n-3)));
}
else
{
  System.out.println((n*(n-1)*(n-2)));
}
}

}
}