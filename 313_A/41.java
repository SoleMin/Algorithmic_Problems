import java.io.*;
import java.util.*;
public class j
{
public static void main(String aa[])throws IOException
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
int i=0,m=0,p=0,n=0,k=0,j=0;
String s,r;
s=b.readLine();
r=s;
n=Integer.parseInt(s);
s=s.substring(0,s.length()-2);
s+=r.charAt(r.length()-1);
r=r.substring(0,r.length()-1);
m=Integer.parseInt(s);
p=Integer.parseInt(r);
System.out.print((long)Math.max(Math.max(m,n),p));
}
}