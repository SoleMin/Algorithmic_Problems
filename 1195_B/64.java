import java.util.Scanner;

public class SportMafia {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int next = 1;
		int current = 0;
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			if(current < k) {
				current += next++;
			} else {
				current--;
				result++;
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}
}
