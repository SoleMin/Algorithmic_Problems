import java.util.*;
public class Lucky {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		if(n%4==0 || n%7==0 || n%47==0 || n%74==0 || n%474==0 || n%447==0 || n%774==0 || n%747==0 || n%477==0 || n%744==0)System.out.println("YES");
		else System.out.println("NO");
	}

}
