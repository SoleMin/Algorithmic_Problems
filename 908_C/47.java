import java.util.Scanner;

public class TaskC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), r = sc.nextInt();
		int[] xcords = new int[n];
		double[] ycords = new double[n];
		double y = r, x = 0, px = 0, ty = 0;
		for(int i = 0; i < n; i++) {
			xcords[i] = sc.nextInt();
			x = xcords[i];
			y = r;
			for(int j = 0; j < i; j++) {
				px = xcords[j];
				if(Math.abs(px - x) > r*2) continue;	
				ty = Math.sqrt(4*r*r - (x-px)*(x-px)) + ycords[j];
				y = Math.max(y, ty);
			}
			ycords[i] = y;
		}
		for(int i = 0; i < n; i++) {
			System.out.print(ycords[i] + " ");
		}
	}

}
