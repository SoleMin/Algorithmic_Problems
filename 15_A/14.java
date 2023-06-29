import java.io.*;
import java.util.*;
public class j
{
public static void main(String a[])throws IOException
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
int k=0,i=0,j=0,n=0,p=0,t=0;
String s;
s=b.readLine();
StringTokenizer c=new StringTokenizer(s);
n=Integer.parseInt(c.nextToken());
k=Integer.parseInt(c.nextToken());
int d[]=new int[n];
int e[]=new int[n];
for(i=0;i<n;i++)
{
s=b.readLine();
StringTokenizer z=new StringTokenizer(s);
d[i]=Integer.parseInt(z.nextToken());
e[i]=Integer.parseInt(z.nextToken());
}
for(i=0;i<n-1;i++)
{
for(j=i+1;j<n;j++)
{
if(d[j]<d[i])
{
t=d[j];
d[j]=d[i];
d[i]=t;
t=e[j];
e[j]=e[i];
e[i]=t;
}
}
}
for(i=0;i<n-1;i++)
{
if(((d[i+1]-e[i+1]/2.0)-(d[i]+e[i]/2.0))>k)
p+=2;
if(((d[i+1]-e[i+1]/2.0)-(d[i]+e[i]/2.0))==k)
p++;
}
System.out.print(p+2);
}
}