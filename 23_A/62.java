import java.io.*;
public class j
{
public static void main(String a[])throws IOException
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
int n=0,i=0,k=2;
String s="\0",r="\0";
s=b.readLine();
n=s.length()-1;
while(k<=s.length())
{
for(i=0;i<k;i++)
{
r=s.substring(i,i+n);
if(s.indexOf(r)!=s.lastIndexOf(r))
{
System.out.print(n);
System.exit(0);
}
}
k++;
n--;
}
System.out.print("0");
}
}