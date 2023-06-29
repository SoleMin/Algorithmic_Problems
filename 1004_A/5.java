
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), d = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = s.nextInt();
		}
		Arrays.sort(arr);
		int count = 0;
		for(int i = 1; i < n; i++){
			int dist = arr[i] - arr[i - 1];
			if(dist > 2 * d){
				count += 2;
			}else if(dist == 2 * d){
				count++;
			}
				
		}
		System.out.println(count + 2);

	}

}
