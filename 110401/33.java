import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int Testcase = scan.nextInt();
		scan.nextLine();
		for(int t=0;t<Testcase;t++) {
			int house = scan.nextInt();
			int d[]=new int[house];
			for(int i=0;i<house;i++)
				d[i]=scan.nextInt();
			scan.nextLine();
			Arrays.sort(d);
			int median = d[house/2];
			int sum=0;
			//System.out.println(median);
			for(int i=0;i<house;i++)
				sum+=Math.abs(d[i]-median);
			System.out.println(sum);
		}
		scan.close();
	}
}
