import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int work[][], n; //작업(번호, 소요시간, 벌금), 작업 개수
		
		int tc = sc.nextInt();
		sc.nextLine();
		for(int t=0; t<tc; t++) {
			sc.nextLine();
			n = sc.nextInt();
			work = new int[n][3]; // 0작업번호, 1작업시간, 2벌금
			for(int i=0; i<n; i++) {
				work[i][0] = i;
				work[i][1] = sc.nextInt();
				work[i][2] = sc.nextInt();
				sc.nextLine();
			}
			
			// 비용(벌금/시간) 기준 정렬
			int temp = 0;
			for(int i=n; i>1; i--) {
				for(int j=1; j<i; j++) {
					// 비용이 클수록 먼저 처리
					// 같은 비용일 때 시간이 짧은 것 먼저 처리
					if(((float)work[j][2]/(float)work[j][1]) <
						((float)work[j-1][2]/(float)work[j-1][1])) {
						continue;
					}
					else if(((float)work[j][2]/(float)work[j][1]) ==
								 ((float)work[j-1][2]/(float)work[j-1][1])) {
						if(work[j][1] > work[j-1][1])
							continue;
					}
					
					for(int h=0; h<3; h++) {
						temp = work[j][h];
						work[j][h] = work[j-1][h];
						work[j-1][h] = temp;
					}
				}
			}
			
			for(int i=0; i<n; i++)
				System.out.print((work[i][0]+1) + " ");
			System.out.println(); System.out.println();
		}
		
		sc.close();
	}
}