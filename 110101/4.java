import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		long lbound, ubound, lbOrg, ubOrg, temp;
		long length, max_length;
		
		while(scan.hasNextLong()) {
			lbound = scan.nextLong();
			ubound = scan.nextLong();
			
			lbOrg = lbound;
			ubOrg = ubound;
			if(lbound > ubound) {
				temp = lbound;
				lbound = ubound;
				ubound = temp;
			}
			max_length = 0;
			long j;
			for(long i = lbound; i <= ubound; i++) {
				j = i;
				length = 1;
				while(j != 1) {
					if(j % 2 != 0) {
						j = j * 3 + 1;
						length++;
					}
					while(j % 2 == 0) {
						j /= 2;
						length++;
					}
				}
				if(length > max_length)
					max_length = length;
			}
			System.out.println(lbOrg + " " + ubOrg + " " + max_length);
		}
	}
}