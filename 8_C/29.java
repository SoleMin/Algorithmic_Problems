import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Handbag
{
	// http://codeforces.com/problemset/problem/8/C	
	// Source of most code : http://codeforces.com/contest/8/submission/3492661
	
	// Keep track of each item location and also be able to 
	// calculate distance between it and another object
	public static class Item{
		int x;
		int y;
		
		Item(int x, int y){
			this.x = x; 
			this.y = y;
		}
		
		// Return distance between two points
		public int dist(Item i){
			int dx = x - i.x;
			int dy = y - i.y;
			return dx*dx + dy*dy;
		}
	}
	
	// Each value in bits[] is the min time to get certain objects
    // Ex. bits[6] = 110 is the fastest time to get items that correspond with the '1s'
	public static int solve(int bitNum){
		
		if(bitNum == (1 << N) - 1) // If bitNum is too big for the array
			return 0;
		
		if(bits[bitNum] != -1) // If bit value has already been calculated
			return bits[bitNum];
		
		int ans = Integer.MAX_VALUE;
		int j = 0;
		for(int i = 1; i < N; i++){
			
			if((bitNum & (1 << i)) == 0){ // Performs bitwise AND operation to see if bitNum and i have no bits in common
				
				if(j == 0){ // Only happens on the first time in IF statement
					// One item that can be picked up before returning to handbag
					ans = 2 * items[0].dist(items[i]) + solve(bitNum | (1 << i)); // Performs bitwise exclusive OR operation
					j = i; // Change value so this case isn't ever hit again && to store value to use in else statement dists
				}
				else{
					// Find the distance between the handbag and the first item
					int dist1 = items[0].dist(items[i]);
					// Find the distance between the first item and the second item
					int dist2 = items[i].dist(items[j]);
					// Find the distance between the second item and the handbag
					int dist3 = items[j].dist(items[0]);
					
					// Two items that can be picked up before returning to handbag
					// distance covered between any two objects in the time equal 
					// to the squared length of the segment between the points of the objects
					ans = Math.min(ans, dist1 + dist2 + dist3 + solve(bitNum | (1 << i) | (1 << j))); // Performs bitwise exclusive OR operation
				}
			}
		}
		return bits[bitNum] = ans; // Store all values in bits[] to speed up solve and for use in printOptPath
	}
	
	static void printOptPath(int bitNum) {
		if (bitNum == (1 << N) - 1)
			return;
		
		// Almost identical to solve equation except it doesn't calculate the answer, it checks the stored answer in bits 
		int j = 0;
		for (int i = 1; i < N; i++)
			
			if ((bitNum & (1 << i)) == 0) {				
				if (j == 0) {					
					j = i; // Change value so this case isn't ever hit again && to find distance to this specific item in else if statement
					if (bits[bitNum] == 2 * items[0].dist(items[i]) + solve(bitNum | (1 << i))) { // solve() should quickly return an answer because the bits[] has already been calculated						
						pw.print(" " + i + " 0"); // One item that can be picked up before returning to handbag
						printOptPath(bitNum | (1 << i)); // Recursively call print with new bitNum
						return;
					}
				} 
				else if (bits[bitNum] == 
								items[0].dist(items[i]) + items[i].dist(items[j]) + items[j].dist(items[0]) + solve(bitNum | (1 << i) | (1 << j))) {
					
					pw.print(" " + j + " " + i + " 0"); // Two items that can be picked up before returning to handbag
					printOptPath(bitNum | (1 << i) | (1 << j)); // Recursively call print with new bitNum
					return;
				}
			}
	}
	
	private static int N = 0;
	private static Item[] items;
	private static int[] bits;
	
	// PrintWriter needs to be class member because of recursive print strategy
	private static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		String[] input = br.readLine().split(" ");
		Item handbag = new Item(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		
		N = Integer.parseInt(br.readLine()) + 1;
		items = new Item[N];
		for(int n = 1; n < N; n++){
			input = br.readLine().split(" ");
			items[n] = new Item(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}		
		items[0] = handbag;
		
		// x << n is a right shift operator 
		// which will remove the last n bits from x
		// Ex 1 << 2 => 4
		bits = new int[1 << N]; // Ex: 1 << 3 = 8; 1 << 5 = 64
		Arrays.fill(bits, -1); // Init bits array to hold -1 values
		
		int ans = solve(1 << 0); // Start solving with bit #1
		pw.println(ans); // Min time needed to put items in handbag
		
		pw.print("0"); // Init output with handbag location
		printOptPath(1 << 0); // Print possible optimum path to pick up items
		
		pw.close();
	}
}
