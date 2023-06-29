import java.util.*;
import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();
		for(int cn=0; cn<casenum; cn++){
			int n = scan.nextInt();
			int r [] = new int[n];
			for(int i=0; i<n; i++){
				r[i] = scan.nextInt();
			}
			scan.nextLine();
			int mid = n/2;
			Arrays.sort(r);
			int middle = r[mid];
			int count=0;
			for(int j=0; j<n; j++){
				count += r[j] > middle? r[j]-middle:middle-r[j];
			}
			System.out.println(count);
		}
	}
}
