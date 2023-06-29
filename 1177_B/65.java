import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeForces1177B {
	
	public static char custBinSearch(long lower, long upper, long lowIndex, int ten, long position) {
		long half = Math.round((lower + upper) / 2.0);
		
		long lowBound = lowIndex + (half - lower)*(ten + 1);
		long upBound = lowBound + ten;
		
		if(position < lowBound) { //Less than the lowest index of half
			return custBinSearch(lower, half - 1, lowIndex, ten, position);
			
		} else if (position > upBound) { //Remember to update lowIndex here.
			lowIndex += (half + 1 - lower)*(ten + 1);
			return custBinSearch(half + 1, upper, lowIndex, ten, position);
			
		} else {
			return Long.toString(half).charAt((int) (position - lowBound)); //The final number will at max be 11 characters long, thus it is safe to convert and cast.
			
		}
		
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader inputs = new BufferedReader(new InputStreamReader(System.in));
		
		long indexPosition = Long.parseLong(inputs.readLine());
		
		inputs.close();
		
		//Isolate possible combinations so that all further numbers will have the same length.
		int tenFactor = 0;
		long lowerBound = 1;
		long upperBound = (long) (Math.pow(10, 12));
		long lowerIndexBound = 1;
		long redIndex = 0;
		redIndex += indexPosition;
		
		while(redIndex > 0) {
			redIndex -= (long) (9*Math.pow(10, tenFactor)*(tenFactor + 1));
			if(redIndex <= 0) { //Stage 1: Completed Successfully.
				lowerBound = (long) (Math.pow(10, tenFactor));
				upperBound = (long) (Math.pow(10, tenFactor + 1) - 1);
				break;
			}
			
			lowerIndexBound += (long) (9*Math.pow(10, tenFactor)*(tenFactor + 1));
			tenFactor++;
			
		}
		
		System.out.println(custBinSearch(lowerBound, upperBound, lowerIndexBound, tenFactor, indexPosition));
		
	}
}
