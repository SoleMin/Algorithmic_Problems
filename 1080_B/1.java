import java.util.*;
public class MargariteAndTheBestPresent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		int l = 0;
		int r = 0;
		List<Integer> z = new ArrayList<>();
		for(int j=0;j<q;j++) {
			l = sc.nextInt();
			r = sc.nextInt();
			System.out.println(func(r) - func(l-1));
		}	
	}
	static long func(long x) {
		if(x%2==0) {
			return x/2;
		}
		else {
			return -x+func(x-1);
		}
	}
}