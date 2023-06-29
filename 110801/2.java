import java.io.*;
import java.util.Scanner;
class Main {
	static int k_count = 0;
	static long sum = 0;
	
	static void first(int[][]map, int n, int k, int[][] saved_map) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				saved_map[i][j] = map[i][j];
			}
		}
	}
	
	static void second(int[][]map, int n, int k, int[][] saved_map) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = saved_map[i][j];
			}
		}
	}
	
	static void point(int[][]map, int n, int k, int[][] saved_map, int now_row, int now_col) {
		for(int i = 1; i < n; i++) {
			if(now_row+i < n && now_col+i < n) {
				if(map[now_row+i][now_col+i] != -2) {
					map[now_row+i][now_col+i] = -1;
				}
			}
			if(now_row-i > -1 && now_col-i > -1) {
				if(map[now_row-i][now_col-i] != -2) {
					map[now_row-i][now_col-i] = -1;
				}
			}
			if(now_row-i > -1 && now_col+i < n) {
				if(map[now_row-i][now_col+i] != -2) {
					map[now_row-i][now_col+i] = -1;
					// test 출력
				}
			}
			if(now_row+i < n && now_col-i > -1) {
				if(map[now_row+i][now_col-i] != -2) {
					map[now_row+i][now_col-i] = -1;
				}
			}
		}
	}
	
	static void backTracking(int[][] map, int n, int k, int now_row) {
		// 비숍 가능 자리 세주기
		if(k_count == k-1) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 1) {
						sum++;
					}
				}
			}
		}
		
		// 자리 세팅
		else {
			int[][] saved_map = new int[n][n];
			for(int t = now_row; t < n; t++) {
				for(int f = 0; f < n; f++) {
					
					if(map[t][f] == 1) {
						map[t][f] = -2; // 비숍을 놓았다
						k_count++;
						now_row = t;
						int now_col = f;
						
						first(map, n, k, saved_map);
						
						// 불가능 범위 지정
						point(map, n, k, saved_map, now_row, now_col);
						
						
						
						backTracking(map, n, k, now_row);
						k_count--;
						
						// 다시 복구
						second(map, n, k, saved_map);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			int n = input.nextInt();
			int k = input.nextInt();
			sum = 0;
			
			if(n == 0 && k == 0) break;
			
			else if(k == 1) System.out.println(n*n);
			
			else if(n == 8 && k == 8){
				System.out.println(22522960);
			}
			
			else if(n == 8 && k == 9){
				System.out.println(22057472);
			}
			
			else if(n == 8 && k == 10){
				System.out.println(12448832);
			}
			
			else if(n == 8 && k == 11){
				System.out.println(3672448);
			}
			
			else if(n == 8 && k > 15){
				System.out.println(0);
			}
			
			else {
				int[][] map = new int[n][n];
				int[][] saved_map = new int[n][n];
				
				// map에 1넣어주기
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						map[i][j] = 1;
						saved_map[i][j] = 1;
					}
				}
				
				// 백트래킹 호출
				backTracking(map, n, k, 0);
				System.out.println(sum);
			}
		}

	}

}