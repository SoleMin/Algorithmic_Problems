import java.util.Arrays;
import java.util.Scanner;

public class Array {
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		/*
		if ( k == 1 ){ 
			System.out.println("1 1"); return;
		}
		*/
		int last[] = new int[100001];
		int distinct = 0;
		for ( int i = 0 ; i < n ; ++i ) {
			int t = in.nextInt();
			if ( last[t] == 0 ) ++distinct;
			last[t] = i+1;
			if ( distinct == k ) {
				int min = i+1;
				for ( int j = 0 ; j < last.length ; ++j ) {
					if ( last[j] != 0 ) min = min>last[j]?last[j]:min;
				}
				System.out.println(min+" "+(i+1)); return;
			}
		}
		System.out.println("-1 -1"); 
	}
	
}
