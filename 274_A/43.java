import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class C {
	
	public static final long MAX = 1000000000L;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tok1 = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(tok1.nextToken());
		final long k = Integer.parseInt(tok1.nextToken());
		
		StringTokenizer tok2 = new StringTokenizer(br.readLine());
		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = Integer.parseInt(tok2.nextToken());
		}
		
		int size = n;
		
		Arrays.sort(array);
		
		boolean[] skip = new boolean[n];
		for(int i = 0; i < n; i++){
			if(skip[i]){
				size--;
				continue;
			}
			
			long input = array[i];
			input *= k;
			if(input > MAX){
				continue;
			}
			
			
			final int pos = Arrays.binarySearch(array, (int)(input));
			if(pos >= 0 && !skip[pos]){
				skip[pos] = true;
			}
		}
		
		System.out.println(size);
	}
}
