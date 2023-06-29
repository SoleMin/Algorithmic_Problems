import java.util.*;

public class ex1 {
	
	public static void main(String[] args)	{
		int n,i,j;
		Scanner scan = new Scanner(System.in);
		n = Integer.parseInt(scan.nextLine());
		if(n>=0)
			System.out.println(n);
		else if(n<0)	{
			n=-1*n;
			i=n/10;
			j=(n/100)*10+n%10;
			i=-i;
			j=-j;
			if(i>=j)
				System.out.println(i);
			else
				System.out.println(j);
		}
	}
	
}
