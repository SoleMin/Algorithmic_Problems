import java.util.Scanner;

public class Main {
	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
	public static void main(String[] args) {
	int n, odd = 0, even = 0;
	int[] input = new int[100];
	n = STDIN_SCANNER.nextInt();
	for(int i = 0; i < n; i++) {
		input[i] = STDIN_SCANNER.nextInt();
		if(input[i] % 2 == 0) {
			odd++;
		} else {
			even++;
		}
	}
	if(odd < even) {
		for(int i = 0; i < n; i++) {
			if(input[i] % 2 == 0) {
				System.out.print(i + 1);
				break;
			}
		}
	} else {
		for(int i = 0; i < n; i++) {
			if(input[i] % 2 != 0) {
				System.out.print(i + 1);
				break;
			}
		}
	}
}
}
 						 	     		  	 				  			