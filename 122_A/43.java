import java.util.Scanner;

public class A_Lucky_Division {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int number=input.nextInt();
		int flag=0;
		if(number%4==0)flag=1;
		else if(number%7==0)flag=1;
		else if(number%47==0)flag=1;
		else if(number%74==0)flag=1;
		else if(number%444==0)flag=1;
		else if(number%447==0)flag=1;
		else if(number%474==0)flag=1;
		else if(number%477==0)flag=1;
		else if(number%744==0)flag=1;
		else if(number%747==0)flag=1;
		else if(number%774==0)flag=1;
		else if(number%777==0)flag=1;
		if(flag==1)System.out.println("YES");
		else System.out.println("NO");
		
	}
}
