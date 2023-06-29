import java.io.*;
import java.util.Scanner;
import java.util.stream.LongStream;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			long i = sc.nextInt();
			long j = sc.nextInt();
			long start = i;
			long end = j;
			long temp = 0;
			if(start> end) {
				temp = j;
				end = i;
				start = temp;
			}
			long max = LongStream.rangeClosed(start,end).map(n -> {
				int count = 0;
				while(n != 1) {
					if( (n & 1) == 1) {
						n = 3*n+1;
						count+=1;
					}
					while( (n & 1) != 1) {
						n >>= 1;
						count +=1;
					}
				}
			return count+1;
			}).max().orElse(-1);
			
			System.out.printf("%d %d %d\n",i,j,max);
		}
		
	}
}