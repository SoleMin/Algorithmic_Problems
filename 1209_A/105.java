import java.util.*;
import java.io.*;

public class paint {
	static PriorityQueue<Integer> sequence;
	
	public static void main (String [] args) throws IOException {
	    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out, true);
	    int numSeq = Integer.parseInt(f.readLine());
	    sequence = new PriorityQueue<Integer>();
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    for(int i = 0; i < numSeq; i++) {
	    	sequence.add(Integer.parseInt(st.nextToken()));
	    }
	    
	    int numColors = 0;
	    while(sequence.size() > 0) {
	    	numColors++;
	    	int smallest = sequence.poll();
	    	PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
	    	for(int each: sequence) {
	    		if(each % smallest != 0) {
	    			temp.add(each);
	    		}
	    	}
	    	sequence = temp;
	    }
	    
	    System.out.println(numColors);
	    out.close();
	}
	
}
