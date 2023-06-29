import java.util.Scanner;

public class CottageVillage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int posCount = 2;
		double[] pos = new double[n];
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			pos[i] = in.nextInt();
			a[i] = in.nextInt();
			// int pos = in.nextInt();
			// int a = in.nextInt();
			// if ((pos - (a / 2)) - (lpos + (la / 2)) >= t)
			// posCount += 2;
			// if ((pos - (a / 2)) - (lpos + (la / 2)) == t)
			// posCount--;
			// lpos = pos;
			// la = a;
		}
		for (int i = 1; i < n; i++) {
			int posk = (int) pos[i];
			int ak = (int) a[i];
			int j = i - 1;
			while (j >= 0 && pos[j] > posk) {
				pos[j + 1] = pos[j];
				a[j + 1] = a[j];
				j--;
			}
			pos[j + 1] = posk;
			a[j + 1] = ak;
		}
		for (int i = 1; i < n; i++) {
			if ((pos[i] - (a[i] / 2)) - (pos[i - 1] + (a[i - 1] / 2)) > t)
				posCount += 2;
			if ((pos[i] - (a[i] / 2)) - (pos[i - 1] + (a[i - 1] / 2)) == t)
				posCount += 1;
		}
//		for (int i = 0; i < n; i++)
//			System.out.println(pos[i] + " " + a[i]);
		 System.out.println(posCount);
	}
}
