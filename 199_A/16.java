import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hexadecimaltheorem {
	public static void main(String[] args) {
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		int x;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		arr.add(1);
		try {
			while ((x = Integer.parseInt(buf.readLine())) != -1) {
				if (x == 1) {

					System.out.println(arr.get(0) + " " + arr.get(0) + " "
							+ arr.get(1));
				} else if (x == 0) {
					System.out.println(arr.get(0) + " " + arr.get(0) + " "
							+ arr.get(0));
				} else {
					int i = 1;
					while (x > arr.get(arr.size() - 1)) {
						arr.add(arr.get(i) + arr.get(i - 1));
						i++;
					}
					System.out.println(arr.get(0) + " " + arr.get(i - 2) + " "
							+ arr.get(i - 1));
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
