import java.util.*;

public class Weee {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] arr = new String[n];
		String[] sss = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = input.next();
			sss[i] = arr[i];
		}
		boolean flag = true;
		label:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[j].length() >= arr[i].length()) {
					if (arr[j].indexOf(arr[i]) < 0) {
						System.out.println("NO");
						flag = false;
						break label;
					}
				}
				if (sss[j].length() < sss[i].length() && j>i) {
					String temp = sss[i];
					sss[i] = sss[j];
					sss[j] = temp;
				}
			}

		}
		if (flag) {
			System.out.println("YES");
			for (int i = 0; i < n; i++) {
				System.out.println(sss[i]);
			}
		}

	}
}