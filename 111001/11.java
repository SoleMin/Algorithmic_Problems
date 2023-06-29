import java.util.*;
class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		int scenario = Integer.parseInt(input.nextLine()); //시나리오 갯수입력


		for(int k=0; k<scenario; k++) {
			input.nextLine();
			String numT = input.nextLine();
			int num = Integer.parseInt(numT);

			double[][] coor = new double[num][2];

			for(int i=0; i<num; i++) {
				String sT = input.nextLine();
				String[] sTT = sT.split(" ");
				coor[i][0] = Double.valueOf(sTT[0]);
				coor[i][1] = Double.valueOf(sTT[1]);
			}
			
			double[][] W = new double[num][num];
			for(int i=0; i<num; i++) {
				for(int j=0; j<num; j++) {
					if(i==j) {
						continue;
					}
					else {
						double length = Math.sqrt((coor[i][0]-coor[j][0])*(coor[i][0]-coor[j][0]) +
								(coor[i][1]-coor[j][1])*(coor[i][1]-coor[j][1]));
						W[i][j] = length;
					}
				}
			}
			
//			for(int i=0; i<num; i++) {
//				for(int j=0; j<num; j++) {
//					System.out.print(W[i][j] + "\t");
//				}
//				System.out.println();
//			}
			
			double cost = prim(W, num);
			System.out.printf("%.2f", cost);
			System.out.println();
			System.out.println();
		}
	}
	
	public static double prim(double[][] W, int n) {
		boolean[] visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			visit[i] = false;
		}
		
		visit[0] = true;
		int node = 0;
		double total = 0;
		
		for(int i=1; i<n; i++) {
			double min = Double.MAX_VALUE;
			for(int k=0; k<n; k++) {
				if(visit[k]==true) {
					//만들어진 MST에 포함된노드면
					for(int l=0; l<n; l++) {
						if(visit[l]==false) {
							//MST에 포함이안된노그까지 거리가 가장 작은것 구함
							if(W[k][l]<min) {
								min = W[k][l];
								node = l;
							}
						}
						
					}
				}
				
			}
			visit[node] = true;
			total += min;
		}
		
		return total;
	}
}