import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class A23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = s.length(); i >= 1; i--) {
			map.clear();
			for (int j = 0; j < s.length()-i+1; j++) {
				String temp = s.substring(j, j+i);
				if (map.containsKey(temp)) {
					System.out.println(i);
					return;
				}
				map.put(temp, true);
			}
		}
		System.out.println(0);
	}

}
