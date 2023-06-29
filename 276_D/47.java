import java.io.PrintWriter;
import java.util.Scanner;

public class D {
	
	public static void main(String [] args){
		Scanner cin = new Scanner(System.in);
		PrintWriter cout = new PrintWriter(System.out);
		long l = cin.nextLong(), r = cin.nextLong(), k = 1;
		if (l == r)cout.println(0);
		else {
			while (((r>>k)<<k)>l)k++;k--;
			cout.println(((r>>k)<<k)^(((r>>k)<<k)-1));
		}
		cout.flush();
	}

}