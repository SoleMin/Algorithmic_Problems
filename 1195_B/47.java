import java.util.*;
public class CFEdu66 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long k = in.nextLong();
		double tmp = Math.sqrt(9 + 8*(n+k));
		if(Math.ceil(tmp)-tmp<0.001)
			tmp = Math.ceil(tmp);
		
		long root = (long)tmp;
		long x = (-3+root)/2;
		System.out.println(n-x);
		
	}

}
