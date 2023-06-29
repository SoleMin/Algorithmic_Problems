//7_2
import java.math.BigInteger;
import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		BigInteger f[]=new BigInteger[1002];
		f[1]=BigInteger.valueOf(2);
		f[2]=BigInteger.valueOf(5);
		f[3]=BigInteger.valueOf(13);
		for(int i =4;i<1001;i++)
			f[i]=f[i-1].add(f[i-1].add(f[i-2].add(f[i-3])));
		while(scan.hasNextLine()) {
			String s= scan.nextLine();
			if(s.equals("")) break;
			int index=Integer.parseInt(s);
			System.out.println(f[index]);
		}
	}
}
//f(n)=2*f(n-1)+f(n-2)+f(n-3) n>3