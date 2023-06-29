import java.util.Scanner;
public class main
{
public static void main(String[]args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int k=sc.nextInt();
int res=0;
res=k/n;
int r=k%n;
if(r!=0)
System.out.println(res+1);
else if(r==0)
System.out.println(res);
}
}