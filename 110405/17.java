import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	public static void main(String[] args) throws Exception {
		
		List<Double> div = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		
		int casenum = sc.nextInt();
		double time, penalty;
		
		for (int i = 0; i < casenum; i++) {
			int order = sc.nextInt();
			double[] temp = new double[order];
			div.clear();
			
			for (int j = 0; j < order; j++) {
				time = sc.nextDouble();
				penalty = sc.nextDouble();
				div.add(penalty/time);
				temp[j] = penalty/time;
			}
			
			Collections.sort(div, Collections.reverseOrder());
			
			for (int j = 0; j < order; j++) {
				for (int k = 0; k < order; k++) {
					if (div.get(j) == temp[k]) {
						System.out.printf("%d ", k+1);
						temp[k] = 0;
						break;
					}
				}
			}
			System.out.println();
			System.out.println();
		}
	}
}