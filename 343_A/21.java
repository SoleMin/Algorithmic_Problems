//package CF;

// Div One
import java.util.*;

public class CFA_200 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		long y = sc.nextLong();
		
		System.out.println(Wilf_tree(x, y));
		
		sc.close();
	}
	
	static long Wilf_tree(long a,long b)
	{
		if(a==0||b==0)
			return 0;
		if(a>=b)
			return a/b+Wilf_tree(a%b, b);
		else
			return b/a+Wilf_tree(a, b%a);
	}

}
