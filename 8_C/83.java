import java.util.Scanner;


public class CF_8C {

	public static void main(String[] args) {
		
		// Hooray bitmasks! I'm good at these :)
		
		Scanner in = new Scanner(System.in);
		
		// Handbag coordinates..
		int hb_x = in.nextInt(), hb_y = in.nextInt();
		int n = in.nextInt();
		int[] ox = new int[n];
		int[] oy = new int[n];
		
		// Dynamic programming: Also store a matrix of the time to reach one
		//  object from the other.
		// This considers the handbag to be object 0
		int[][] dt = new int[n][n];
		int[] hbd = new int[n];
		for (int i = 0; i < n; i++) {
			ox[i] = in.nextInt();
			oy[i] = in.nextInt();
			hbd[i] = (ox[i] - hb_x) * (ox[i] - hb_x)
					+ (oy[i] - hb_y) * (oy[i] - hb_y);
		}
		
		// Compute elapsed times...
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dt[i][j] = (ox[i] - ox[j]) * (ox[i] - ox[j])
						+ (oy[i] - oy[j]) * (oy[i] - oy[j]);
			}
		}
		
		// Fill up an array with the amount of time it takes to grab
		//  all objects with the specified bitmask.
		int[] sofar = new int[1 << n];
		int[] masks = new int[1 << n];
		sofar[0] = 0;
		for (int i = 1; i < (1 << n); i++) {
			sofar[i] = -1;
		}
		
		for (int i = 0; i < (1 << n); i++) {
			if (sofar[i] != -1) {
				for (int maskbit = 0; maskbit < n; maskbit++) {
					// Look for first object in bitmask to grab...
					if (((1 << maskbit) & i) == 0) {
						int iffirst = ((1 << maskbit) | i);
						int fromold = sofar[i] + 2 * hbd[maskbit];
						
						if (sofar[iffirst] == -1 || sofar[iffirst] > fromold) {
							// A better way to get to position J was found, use it.
							sofar[iffirst] = fromold;
							masks[iffirst] = i;
						}
						
						// Find another thing while you're out...
						for (int otherone = 0; otherone < n; otherone++) {
							if (((1 << otherone) & iffirst) == 0) {
								int iffollow = ((1 << otherone) | iffirst);
								int fromi = sofar[i] + hbd[maskbit] + dt[maskbit][otherone] + hbd[otherone];
								
								// Did we find a better way to get to iffollow state?
								if (sofar[iffollow] == -1 || sofar[iffollow] > fromi) {
									sofar[iffollow] = fromi;
									masks[iffollow] = i;
								}
							}
						}
						break;
					}
				}
			}
		}
		
		// After all this time, we have an answer.
		// The minimum time will be the value of sofar at the very end,
		//  which will have the case of if all objects were picked up.
		// Clever, no?
		// The logic came from http://www.darrensun.com/codeforces-round-8/
		// Wish I could claim it mine, but it is not so.
		
		int end_val = (1 << n) - 1;
		
		System.out.println(sofar[end_val]);
		System.out.print(0);
		while (end_val > 0) {
			// Which objects were collected in the prvious trip?
			int diff = end_val ^ masks[end_val];
			int obj1 = -1, obj2 = -1;
			for (int i = 0; i < n; i++) {
				if (((1 << i) & diff) > 0) {
					obj2 = obj1;
					obj1 = i;
				}
			}
			
			if (obj2 >= 0) {
				// Two objects were collected this trip, output them both.
				System.out.print(" " + (obj1 + 1) + " " + (obj2 + 1) + " 0");
			} else {
				// Only one object was collected here.
				System.out.print(" " + (obj1 + 1) + " 0");
			}
			end_val = masks[end_val];
		}
		
		in.close();
	}

}
