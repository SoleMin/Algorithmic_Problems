import java.util.Scanner;

public class Digits_Sequence_Hard_Edition_Kamel {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		getResult(k);
		sc.close();
	}
	
	static void getResult(long k) {
		long val = 0;;
		long ten = 1;
		int i = 1;
		while(true) {
			val = 9l*ten*i;
			if(k<=val) {
				decompose(k, ten, i);
				System.exit(0);
			}
			else {
				k-=val;
				ten = ten*10l;
				i++;
			}
		}
	}
	
	static void decompose(long offset, long ten, int size) {
		long val = ten - 1 +(long) Math.ceil((double)offset/size);
		int digit = (int)(((offset%size))-1 + size)%size;
		
		String result = String.valueOf(val).substring(digit, digit+1);
		System.out.print(result);
	}
}
