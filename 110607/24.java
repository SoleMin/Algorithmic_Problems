import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<Integer> num = new ArrayList<>();
		List<Integer> f = new ArrayList<>();
		int max = 0;
		f.add(0);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if(n == 0)
				break;
			
			if(max < n)
				max = n;
			num.add(n);
		}
		f.add(1);
		for(int i = 2; i <= max; i++) {
			int last = f.get(i-1);
			if(last ==  f.get(i-f.get(last)))
				f.add(last+1);
			else
				f.add(last);
		}
		
		for(int n : num) {
			System.out.println(f.get(n));
		}
	}
}