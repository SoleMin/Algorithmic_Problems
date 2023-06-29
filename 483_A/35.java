import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		long l = Long.parseLong(line[0]);
		long r = Long.parseLong(line[1]);
		if(r-l < 2 || ((r-l == 2) && (l % 2 == 1)))
			System.out.println("-1");
		else
		{
			Long start = l + (l%2); 
			System.out.println(start + " " + (start + 1) + " " + (start + 2));
		}
	}
}
