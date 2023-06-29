import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String c = String.valueOf(l);
		if (String.valueOf(c).contains("0") || String.valueOf(c).contains("1")
				|| String.valueOf(c).contains("2")
				|| String.valueOf(c).contains("3")
				|| String.valueOf(c).contains("5")
				|| String.valueOf(c).contains("6")
				|| String.valueOf(c).contains("8")
				|| String.valueOf(c).contains("9"))
			if (l % 777 == 0 || l % 774 == 0 || l % 747 == 0 || l % 744 == 0
					|| l % 477 == 0 || l % 474 == 0 || l % 447 == 0
					|| l % 444 == 0 || l % 77 == 0 || l % 74 == 0
					|| l % 47 == 0 || l % 44 == 0 || l % 7 == 0 || l % 4 == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		else
			System.out.println("YES");
	}

}
