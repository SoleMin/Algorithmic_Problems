import java.util.Scanner;


public class CF275Ad2 {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		long l = scan.nextLong();
		long r = scan.nextLong();
		
		long diff = r-l;
		boolean exists = false;
		if(diff >= 3){
			if(l%2 == 1){
				l++;
			}
			exists = true;
		} else if(diff == 2 && l%2 == 0){
			exists = true;
		} else if(diff == 2 && gcd(l, r) > 1){
			exists = true;
		}
		
		if(!exists){
			System.out.println("-1");
		} else {
			System.out.println(l + " " + (l+1) + " " + (l+2));
		}
	}
	
	private static long gcd(long a, long b){
		if(b == 0){
			return 1;
		} 
		return gcd(b, a % b);
	}

}
