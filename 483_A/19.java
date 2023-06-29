import java.util.Scanner;

public class dwl {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] lr = sc.nextLine().split(" ");
		long l = Long.valueOf(lr[0]);
		long r = Long.valueOf(lr[1]);

		if (r - l <= 1 || (l == 1 && (r - l) == 2)
				|| (l % 2 != 0 && (r - l) < 3))
			System.out.println(-1);
		else {
			if (l == 1)
				System.out.println(2 + " " + 3 + " " + 4);
			else {
				if (l % 2 == 0) {
					String res = "";
					res += l + " ";
					res += (l + 1) + " ";
					res += (l + 2) + " ";
					res = res.trim();
					System.out.println(res);
				} else {
					String res = "";
					res += (l + 1) + " ";
					res += (l + 2) + " ";
					res += (l + 3) + " ";
					res = res.trim();
					System.out.println(res);

				}
			}

		}

	}

}
