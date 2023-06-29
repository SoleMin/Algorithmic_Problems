import java.io.*;
import java.util.*;
public class j
{
public static void main(String a[])throws IOException
{
BufferedReader b = new BufferedReader(new FileReader("input.txt"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
int l=0,x2=0,x=0,y1=0,y=0,max=-1,min=100000,x1=0,n=0,j=0,k=0,p=0,m=0,i=0;
String s;
s=b.readLine();
StringTokenizer c=new StringTokenizer(s);
n=Integer.parseInt(c.nextToken());
m=Integer.parseInt(c.nextToken());
k=Integer.parseInt(b.readLine());
int e[][]=new int[k][2];
s=b.readLine();
StringTokenizer z=new StringTokenizer(s);
for(i=0;i<k;i++)
{
e[i][0]=Integer.parseInt(z.nextToken());
e[i][1]=Integer.parseInt(z.nextToken());
}
for(i=1;i<=n;i++)
{
for(j=1;j<=m;j++)
{
for(l=0;l<k;l++)
{
p=(int)Math.abs(e[l][0]-i)+(int)Math.abs(e[l][1]-j);
if(p<min)
{
min=p;
x1=i;
y1=j;
}
}
if(min>max)
{
max=min;
x=x1;
y=y1;
}
min=100000;
}
}
out.print(x+" "+y);
out.close();
}
}