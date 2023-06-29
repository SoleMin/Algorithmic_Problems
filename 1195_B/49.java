import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		double n=s.nextLong();
		double k=s.nextLong();
		
		double num=(-3+Math.sqrt(9+8*(n+k)))/2;
		
		System.out.println((long)(n-num));
		
	}
	
}