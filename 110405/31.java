import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
	
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		
		for(int i = 0; i < testcase; i++) {
			int index = 1; 
			int n = sc.nextInt();
			sc.nextLine();
			Map<Integer,Double> map = new HashMap<>();
			
			for(int j = 0; j < n; j++) {
				String infos = sc.nextLine();
				String[] info = infos.split(" ");
				double t = Integer.parseInt(info[0])/1.0;
				double p = Integer.parseInt(info[1])/1.0;
				
				double ratio = t/p;
				map.put(index++,ratio);
			}
			List<Map.Entry<Integer,Double>> e = new LinkedList<>(map.entrySet());
			Collections.sort(e,new Comparator<Map.Entry<Integer, Double>>() {
				public int compare(Map.Entry<Integer, Double> a, Map.Entry<Integer,Double> b) {
					return a.getValue().compareTo(b.getValue());
				}
			});
			
			for(Map.Entry<Integer, Double> entry : e) {
				System.out.print(entry.getKey() + " ");
			}

			System.out.println();
			System.out.println();
		}
	}
}