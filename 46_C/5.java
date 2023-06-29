
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	InputStreamReader  inp = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(inp);
	boolean test = false;

	String[] inData = { "9",
"HTHTHTHHT",
		};

	static int id = -1;
	public String readLine() throws IOException {
		id++;
		if(test)
			return inData[id];
		else
			return in.readLine();
	}
	
	
	public Main() throws Throwable {
		
		int animalNr = Integer.valueOf(readLine());
		String animals = readLine();
		
		boolean[] state = new boolean[animalNr];
		int tigerCount = 0;
		for (int i = 0; i < animals.length(); i++) {
			if('T' == animals.charAt(i)){
				state[i] = true;
				tigerCount++;
			}
		}
		int best = Integer.MAX_VALUE;
		for (int i = 0; i < state.length; i++) {
			int swaps = 0;
			for (int j = i; j < i+tigerCount; j++) {
				if(state[j %animalNr] == false){
					swaps ++;
				}
			}
			if(swaps < best){
				best = swaps;
			}
		}
		
		System.out.println(best);
		
	}
	
	
	public static void main(String[] args) throws Throwable {
		new Main();
	}
}