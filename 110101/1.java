import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			int n = input.nextInt();
			int m = input.nextInt();
			int low = n;
			int high = m;
			int maxLength = 0;
			if(low>high){
				int temp = low;
				low = high;
				high = temp;
			}
			for(int i=low; i<= high; i++){
				long j = (long)i;
				int length =1;
				for(int k = 1; j!=1; k++){
					j= (j&1) == 0 ? j/2 : j*3+1;
					length++;
				}
				maxLength = maxLength > length ? maxLength : length;
			}
			System.out.println(n + " " + m + " " + maxLength);
		}
	}
}