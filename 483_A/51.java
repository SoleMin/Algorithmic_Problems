import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long l = s.nextLong();
		long r = s.nextLong();
		s.close();
		
		if (r-l<2 || (r-l==2 && l%2==1)) {
			System.out.print("-1");
			return;
		}
		
		long beg = l%2==0 ? l : l+1;
		if (beg+2>r) System.out.print("-1");
		else System.out.print(beg+" "+(beg+1)+" "+(beg+2));
	}
}
