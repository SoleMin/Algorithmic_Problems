import java.util.*;
public class Main{
public static void main(String[]args){
Scanner input=new Scanner(System.in);
int x=input.nextInt();
if(x%4==0||x%7==0||x%47==0||x%74==0||x%744==0||x%474==0||x%447==0||x%477==0||x%474==0)
System.out.println("YES");
else
System.out.println("NO");
}
}