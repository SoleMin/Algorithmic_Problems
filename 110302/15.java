import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int caseN = sc.nextInt();
		
		for (int cn = 0; cn < caseN; cn++) {
			
		sc.nextLine();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		String [] list = new String [x];
		sc.nextLine();
		for (int i = 0; i < x; i ++) {
			list[i] = sc.nextLine().toLowerCase();
		}
		
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i ++) {
			
			String in = sc.nextLine().toLowerCase();
			char start = in.charAt(0);
			
			int [] index = new int [2];
			int [] result = new int [2];
			result[0] = -1;
			result[1] = -1;
			
			for (int j = 0; j < x; j ++) {
				for (int k = 0; k < y; k++) {
					if (list[j].charAt(k) == start){
						index[0] = j;
						index[1] = k;
						
						// →
						if (y - index[1] >= in.length()) {
							boolean correct = true;
							for (int l = 0; l < in.length(); l++) {
								if(in.charAt(l) != list[index[0]].charAt(index[1]+l)) {
									correct = false;
									break;
								}
							}
							if (correct == true){
								result[0] = index[0] +1;
								result[1] = index[1] +1;
								break;
							}
						}

						// ↘
						if (y - index[1] >= in.length() && x - index[0] >= in.length()) {
							boolean correct = true;
							for (int l = 0; l < in.length(); l++) {
								if (in.charAt(l) != list[index[0]+l].charAt(index[1]+l)) {
									correct = false;
									break;
								}
							}
							if (correct == true) {
								result[0] = index[0] + 1;
								result[1] = index[1] + 1;
								break;
							}
						}
						
						// ↓
						if (x - index[0] >= in.length()) {
							boolean correct  = true;
							for (int l = 0; l < in.length(); l++) {
								if (in.charAt(l) != list[index[0]+l].charAt(index[1])) {
									correct = false;
									break;
								}
							}
							if (correct == true) {
								result[0] = index[0] +1;
								result[1] = index[1] +1;
								break;
							} 
						}
						
						
						// ↙
						if (x - index[0] >= in.length() && y - (y - index[1] -1) >= in.length()) {
							boolean correct = true;
							for (int l = 0; l < in.length(); l++) {
								if (in.charAt(l) != list[index[0] +l].charAt(index[1]-l)){
									correct = false;
									break;
								}
							}
							if(correct == true) {
								result[0] = index[0] +1;
								result[1] = index[1] +1;
								break;
		
							}
						}
						
						
						// ←
						if (y - (y - index[1] -1) >= in.length()) {
							boolean correct = true;
							for (int l = 0; l < in.length(); l++) {
								if(in.charAt(l) != list[index[0]].charAt(index[1]-l)) {
									correct = false;
									break;
								}
							}
							if (correct == true) {
								result[0] = index[0] +1;
								result[1] = index[1] +1;
								break;
							}
						}
						// ↖
						if (y - (y - index[1] -1) >= in.length() && x - (x - index[0] -1) >= in.length()) {
							boolean correct = true;
							for (int l = 0; l < in.length(); l++) {
								if (in.charAt(l) != list[index[0]-l].charAt(index[1]-l)) {
									correct = false;
									break;
								}
							}
							if (correct == true) {
								result[0] = index[0] +1;
								result[1] = index[1] +1;
								break;
							}
						}
						
						
						// ↑
						if (x - (x - index[0] -1) >= in.length()) {
							boolean correct = true;
							for (int l = 0; l < in.length(); l++) {
								if (in.charAt(l) != list[index[0]-l].charAt(index[1])) {
									correct = false;
									break;
								}
							}
							if (correct == true){
								result[0] = index[0] +1;
								result[1] = index[1] +1;
								break;
							}
						}
						
						// ↗
						if (x - (x - index[0] -1) >= in.length() && y -index[1] >= in.length()) {
							boolean correct = true;
							for (int l = 0; l < in.length(); l++){
								if (in.charAt(l) != list[index[0]-l].charAt(index[1]+l)) {
									correct = false;
									break;
								}
							}
							if (correct == true) {
								result[0] = index[0] +1;
								result[1] = index[1] +1;
								break;
							}
						}
					}
				}
				if (result[0] != -1) break;
			}
			
			System.out.println(result[0] + " " + result[1]);

 		}
		System.out.println();
		}
	}
}