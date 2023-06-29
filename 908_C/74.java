import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int d = 2 * r;
		int[] xCoordinates = new int[n];
		double[] yCoordinates = new double[n];
		for (int i = 0; i < n; i++)
			yCoordinates[i] = r;
		for (int i = 0; i < n; i++)
			xCoordinates[i] = sc.nextInt();
		double y = 0;
		for (int i = 0; i < n; i++) {
			y = r;
			for (int j = 0; j < i; j++) {
				if (Math.abs(xCoordinates[i] - xCoordinates[j]) <= 2 * r) {
					int dx = Math.abs(xCoordinates[i] - xCoordinates[j]);
					double dy = Math.sqrt(d * d - dx * dx);
					if (dy + yCoordinates[j] > y)
						y = dy + yCoordinates[j];
				}
			}
			yCoordinates[i]=y;
		}
		for (int i = 0; i < n; i++)
			System.out.print(yCoordinates[i] + " ");
		sc.close();
	}

}
