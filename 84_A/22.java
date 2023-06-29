import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Govnokod {

	public static void main(String args[]) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				String str = br.readLine();
				int i = Integer.parseInt(str);

				System.out.println(i*2-i/2);

				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
