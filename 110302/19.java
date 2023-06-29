import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		int i, j, x, y, k;
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		scanner.nextLine();
		
		for(i = 0; i < n; i++) {
			scanner.nextLine();
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			scanner.nextLine();
			
			String [] line = new String[r];
			
			for(j = 0; j < r; j++) {
				line[j] = scanner.nextLine().toLowerCase();
			}
			
			int o = scanner.nextInt();
			scanner.nextLine();
			
			for(j = 0; j < o; j++) {
				String name = scanner.nextLine().toLowerCase();
				
				int out_r = -1;
				int out_c = -1;
				
				for(x = 0; x < r; x++) {	// row
					for(y = 0; y < c; y++) {	// column
						if(line[x].charAt(y) == name.charAt(0)) {
							int l = name.length();
							boolean left = (y + 1) >= l;
							boolean right = (c - y) >= l;
							boolean up = (x + 1) >= l;
							boolean down = (r - x) >= l;
						
							if(up) {
								boolean found = true;
								for(k = 0; k < l; k++) {
									if(name.charAt(k) != line[x - k].charAt(y)) {
										found = false;
										break;
									}
								}
								if(found) {
									out_r = x + 1;
									out_c = y + 1;
									break;
								}
							}
							
							if(down) {
								boolean found = true;
								for(k = 0; k < l; k++) {
									if(name.charAt(k) != line[x + k].charAt(y)) {
										found = false;
										break;
									}
								}
								if(found) {
									out_r = x + 1;
									out_c = y + 1;
									break;
								}
							}
							
							if(left) {
								boolean found = true;
								for(k = 0; k < l; k++) {
									if(name.charAt(k) != line[x].charAt(y - k)) {
										found = false;
										break;
									}
								}
								if(found) {
									out_r = x + 1;
									out_c = y + 1;
									break;
								}
							}
						
							if(right) {
								boolean found = true;
								for(k = 0; k < l; k++) {
									if(name.charAt(k) != line[x].charAt(y + k)) {
										found = false;
										break;
									}
								}
								if(found) {
									out_r = x + 1;
									out_c = y + 1;
									break;
								}
							}
							
							if(up && left) {
								boolean found = true;
								for(k = 0; k < l; k++) {
									if(name.charAt(k) != line[x - k].charAt(y - k)) {
										found = false;
										break;
									}
								}
								if (found) {
									out_r = x + 1;
									out_c = y + 1;
									break;
								}
							}
							
							if(up && right) {
								boolean found = true;
								for(k = 0; k < l; k++) {
									if(name.charAt(k) != line[x - k].charAt(y + k)) {
										found = false;
										break;
									}
								}
								if(found) {
									out_r = x + 1;
									out_c = y + 1;
									break;
								}
							}
							
							if(down && left) {
								boolean found = true;
								for(k = 0; k < l; k++) {
									if(name.charAt(k) != line[x + k].charAt(y - k)) {
										found = false;
										break;
									}
								}
								if(found) {
									out_r = x + 1;
									out_c = y + 1;
									break;
								}
							}
							
							if(down && right) {
								boolean found = true;
								for (k = 0; k < l; k++) {
									if(name.charAt(k) != line[x + k].charAt(y + k)) {
										found = false;
										break;
									}
								}
								if(found) {
									out_r = x + 1;
									out_c = y + 1;
									break;
								}
							}
					}
				}
					if(out_r != -1 && out_c != -1)
						break;
			}
				System.out.println(out_r + " " + out_c);
		}
		System.out.println("");
	}
	}
	}