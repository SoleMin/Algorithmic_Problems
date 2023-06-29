import java.util.*;
class Main {
	static ArrayList<double[]> v_arr;
	static double[][] distance;
	static boolean[] visit;
	
	public static void solution(int num) {
		double sum = 0.0;
		visit[0] = true;
		for(int k = 0; k < num-1; k++) {
			double final_min = 999999.0;
			int final_index = 0;
			
			for(int i = 0; i < num; i++) {
				if(visit[i] == true) {
					double min = 999999.0;
					int j_index = 0;
					for(int j = 0; j < num; j++) {
						if(j != i && distance[i][j] < min && visit[j] == false) {
							min = distance[i][j];
							j_index = j;
						}
					}
					if(final_min > min) {
						final_min = min;
						final_index = j_index;
					}
				}
			}
			
			sum += final_min;
			visit[final_index] = true;
		}
		
		System.out.printf("%.2f\n\n", sum);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in); 
		int test_case = Integer.parseInt(in.nextLine());
		for(int z = 0; z < test_case; z++){
			in.nextLine();
			v_arr = new ArrayList<>();
			int num = Integer.parseInt(in.nextLine());
			distance = new double[num][num];
			visit = new boolean[num];
			
			for(int i = 0; i < num; i++){
				String[] s_arr = in.nextLine().split(" ");
				double[] val = {Double.parseDouble(s_arr[0]), Double.parseDouble(s_arr[1])};
				v_arr.add(val);
			}
			
			for(int i = 1; i < num; i++) {
				for(int j = 0; j < i; j++) {
					double d = Math.pow(v_arr.get(i)[0]-v_arr.get(j)[0],2) + Math.pow(v_arr.get(i)[1]-v_arr.get(j)[1], 2);
					distance[i][j] = Math.sqrt(d);
					distance[j][i] = Math.sqrt(d);
				}
			}
			
			solution(num);
		}
	}
}