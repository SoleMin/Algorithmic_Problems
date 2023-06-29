import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String input;

			while ((input = reader.readLine()) != null && input.length() > 0) {
				int n = Integer.parseInt(input);
				int start = 4;
				int end = n - start;

				while (start <= end) {
					if ((start % 2 == 0 || start % 3 == 0) && (end % 2 == 0 || end % 3 == 0)) {
						System.out.println(start + " " + end);
						break;
					}
					++start;
					--end;
				}
			}
		}
	}
}