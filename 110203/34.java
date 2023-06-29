import java.io.*;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		int lim,n,i,j,parties;
		Set<Integer> h = new HashSet<>();
		Set<Integer> hdays = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
				
		for( i = 0; i < n; i++ ) {
			int days = sc.nextInt();
			if(days < 7 || days > 3650)
				break;
			parties = sc.nextInt();
			for ( j = 0; j < parties; j++ ) {
				h.add(Integer.valueOf(sc.nextInt()));
			}
			h.stream().forEach(k -> {
				int m;
				for( m = k; m <= days; m += k) {
					if ( m % 7 != 6 && m % 7 != 0 )
						hdays.add(Integer.valueOf(m));
				}
			});
			System.out.println(hdays.size());
			h.clear();
			hdays.clear();
		}
		
		
		
	}
}