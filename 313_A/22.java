import java.io.*;
import java.util.*;

public class first
{
	int max(int a1,int a2,int a3)
	{
		int max=a1;
		if(a2>=max)
			max=a2;
		if(a3>=max)
			max = a3;
		return max;	
	}
	
	public static void main(String[] args)
	{
		int num=0;
		
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int num2 = num/10;
		int num3 = num%10;
		int num4 = (num2/10)*10+num3;
		first fs = new first();
		int result = fs.max(num,num2,num4);
		System.out.println(result);
	}
}	
