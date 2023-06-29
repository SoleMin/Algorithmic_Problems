import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int a = Integer.parseInt(parts[1]);
		int b = Integer.parseInt(parts[2]);
		parts = br.readLine().split("\\s+");
		int[]hard = new int[n];
		for(int i = 0; i < n; i++){
			hard[i] = Integer.parseInt(parts[i]);
		}
		Arrays.sort(hard);
		System.out.println(hard[b]-hard[b-1]);
	}
}
