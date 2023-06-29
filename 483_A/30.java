import java.util.Scanner;
public class Counterexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		long l=sc.nextLong(),r=sc.nextLong();
		if (l%2==0&&r-l>=2) System.out.print(l+" "+(l+1)+" "+(l+2));
		else if (l%2==1&&r-l>=3) System.out.print((l+1)+" "+(l+2)+" "+(l+3));
		else System.out.print("-1");
	}

}
