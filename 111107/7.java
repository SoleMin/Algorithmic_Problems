import java.io.*;

import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
	        Scanner input = new Scanner(System.in);

	        int t = input.nextInt();

	        for (int i = 0; i < t; i++) {
	            int k = input.nextInt();
	            int n = input.nextInt();

	            int[] map = new int[n + 1];
	            for (int j = 0; j < n; j++)
	                map[map.length - j - 1] = input.nextInt();

	            int[][] m = new int[n + 1][k + 9];
	            for (int c = 1; c < m[0].length; c++)
	                for (int r = 0; r < m.length; r++)
	                    m[r][c] = Integer.MAX_VALUE;

	            for (int c = 1; c < m[0].length; c++) {
	                for (int r = 3*c; r < m.length; r++) {
	                    int map1 =map[r - 1] - map[r];
	                    m[r][c] = Math.min(m[r - 1][c], m[r - 2][c - 1] + map1*map1);
	                }
	            }

	            System.out.println(m[n][k + 8]);
	        }
	}
	}