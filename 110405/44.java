import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
	int caseNumber = Integer.parseInt(br.readLine());
		for(int c = 0; c < caseNumber; c++) {
			br.readLine();
			int num = Integer.parseInt(br.readLine());
			int days [] = new int [num];
			int fee[] = new int [num];
			double hourlyFine [] = new double[num];
			int order[] = new int[num];
			
			for(int o = 0; o < num; o++) {
				order[o] = o + 1;
			}
			
			for(int i = 0; i < num; i++) {
				String a = br.readLine();
				days [i] = Integer.parseInt(a.split(" ")[0]);
				fee [i] = Integer.parseInt(a.split(" ")[1]);
			}
			for(int j = 0; j < num; j++) {
				hourlyFine[j] = (double)fee[j] / (double)days[j];
			}
			
			for(int k = 0; k < num - 1; k++) {
				for(int l = k + 1; l < num; l++){
				if(hourlyFine[k] < hourlyFine[l]) {
					double temp = hourlyFine[l];
					hourlyFine[l] = hourlyFine[k];
					hourlyFine[k] = temp;
					int tmp = order[l];
					order[l] = order[k];
					order[k] = tmp;
				}
				}
			}
			for(int d = 0; d < num; d++) {
				System.out.printf(order[d] + " ");
			}
			System.out.println();
			System.out.println();
		}
		
	}
}