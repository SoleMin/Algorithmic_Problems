import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		List<Integer> dis = new ArrayList<Integer>();
		int casenum = sc.nextInt();
		
		for (int i = 0; i < casenum; i++) {
			int house = sc.nextInt();
			dis.clear();
			
			for (int j = 0; j < house; j++) {
				dis.add(sc.nextInt());
			}
			
			dis.sort(null);
			
			int vito = dis.get(dis.size()/2), print = 0;
			
			for (int j = 0; j < dis.size(); j++) {
				print += Math.abs(dis.get(j) - vito);
			}
			
			System.out.println(print);
		}
	}
}