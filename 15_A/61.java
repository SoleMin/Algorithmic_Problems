import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class A {
	
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String[] s = in.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int t = Integer.parseInt(s[1]) * 2;
			
			int[] walls = new int[n*2]; 
			
			for (int i=0; i<n; i++)
			{
				s = in.readLine().split(" ");
				int x = Integer.parseInt(s[0]) * 2;
				int a = Integer.parseInt(s[1]);
				walls[i*2] = x-a;
				walls[i*2+1] = x+a;
			}
			
			Arrays.sort(walls);
			
			int count = 2;
			
			for (int i=1; i<n*2-2; i+=2) {
				int space = walls[i+1] - walls[i]; 
				if ( space == t)
					count += 1;
				else if ( space > t)
					count += 2;
			}
			
			System.out.println (count);

		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
