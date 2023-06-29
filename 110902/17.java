import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;
	
class Main {
	
	static int[] start;
	static int[] result;
	static int[][][][] cheack = new int[10][10][10][10];
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
			int n = Integer.parseInt(input.nextLine());
			/**BFS 최단경로 15쪽에 구현되어 있음**/
			/**백트래킹을 스택 버전으로 하는 건가?**/
			/**양방향 = 무방향**/
		
			for(int i=0; i<n; i++) {
				String garbage = input.nextLine();
				start = Stream.of(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				result = Stream.of(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				
				int no = Integer.parseInt(input.nextLine());
				
				
				for(int t =0; t<10; t++) {
					for(int p =0; p<10; p++) {
						for(int h =0; h<10; h++) {
							for(int l =0; l<10; l++) {
								cheack[t][p][h][l] = 0;
							}
						}
					}
				}
				
				
				for(int j =0; j<no; j++){
					int[] temp = Stream.of(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
					cheack[temp[0]][temp[1]][temp[2]][temp[3]] = -1;
				}
				
				
				int res= bfs();
				System.out.println(res-1);
			}
	}
	
	
	public static int bfs() {
		int[] num1 = new int[10000];
		int[] num2 = new int[10000];
		int[] num3 = new int[10000];
		int[] num4 = new int[10000];
		num1[0] = start[0];
		num2[0] = start[1];
		num3[0] = start[2];
		num4[0] = start[3];
		cheack[start[0]][start[1]][start[2]][start[3]] = 1;
		
		int a =1;
		int b =0;
		int n1;
		int n2;
		int n3;
		int n4;
		int cnt;
		
		int l1;
		int l2;
		int l3;
		int l4;
		
		int r1;
		int r2;
		int r3;
		int r4;
		
		while(a>b && cheack[result[0]][result[1]][result[2]][result[3]] == 0) {
			n1 = num1[b];
			n2 = num2[b];
			n3 = num3[b];
			n4 = num4[b];
			
			cnt = cheack[n1][n2][n3][n4];
			b++;
			
			if(n1 == 0 ) {
				l1 =9;
			}
			else {
				l1 = n1 -1;
			}
			r1 = (n1 + 1)%10;
			
			
			if(n2 == 0 ) {
				l2 =9;
			}
			else {
				l2 = n2 -1;
			}
			r2 = (n2 + 1)%10;
			
			
			if(n3 == 0 ) {
				l3 =9;
			}
			else {
				l3 = n3 -1;
			}
			r3 = (n3 + 1)%10;
			
			
			if(n4 == 0 ) {
				l4 =9;
			}
			else {
				l4 = n4 -1;
			}
			r4 = (n4 + 1)%10;
			
			if(cheack[l1][n2][n3][n4] == 0 ){
				cheack[l1][n2][n3][n4] = cnt + 1;
				num1[a] = l1;
				num2[a] = n2;
				num3[a] = n3;
				num4[a] = n4;
				a++;
			}
			
			if(cheack[r1][n2][n3][n4] == 0 ){
				cheack[r1][n2][n3][n4] = cnt + 1;
				num1[a] = r1;
				num2[a] = n2;
				num3[a] = n3;
				num4[a] = n4;
				a++;
			}
			
			if(cheack[n1][l2][n3][n4] == 0 ){
				cheack[n1][l2][n3][n4] = cnt + 1;
				num1[a] = n1;
				num2[a] = l2;
				num3[a] = n3;
				num4[a] = n4;
				a++;
			}
			
			
			if(cheack[n1][r2][n3][n4] == 0 ){
				cheack[n1][r2][n3][n4] = cnt + 1;
				num1[a] = n1;
				num2[a] = r2;
				num3[a] = n3;
				num4[a] = n4;
				a++;
			}
			
			if(cheack[n1][n2][l3][n4] == 0 ){
				cheack[n1][n2][l3][n4] = cnt + 1;
				num1[a] = n1;
				num2[a] = n2;
				num3[a] = l3;
				num4[a] = n4;
				a++;
			}
			
			if(cheack[n1][n2][r3][n4] == 0 ){
				cheack[n1][n2][r3][n4] = cnt + 1;
				num1[a] = n1;
				num2[a] = n2;
				num3[a] = r3;
				num4[a] = n4;
				a++;
			}
			
			if(cheack[n1][n2][n3][l4] == 0 ){
				cheack[n1][n2][n3][l4] = cnt + 1;
				num1[a] = n1;
				num2[a] = n2;
				num3[a] = n3;
				num4[a] = l4;
				a++;
			}
			
			if(cheack[n1][n2][n3][r4] == 0 ){
				cheack[n1][n2][n3][r4] = cnt + 1;
				num1[a] = n1;
				num2[a] = n2;
				num3[a] = n3;
				num4[a] = r4;
				a++;
			}
		}
		return cheack[result[0]][result[1]][result[2]][result[3]];
	}
}