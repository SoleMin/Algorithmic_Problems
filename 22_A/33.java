import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.util.Arrays;


public class a {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader input = new BufferedReader(new FileReader("input.txt"));
		//BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StreamTokenizer in = new StreamTokenizer(input);
		
		in.nextToken();
		int n = (int)in.nval;
		int[] mas = new int[n];
		
		for (int i = 0; i < n; i++) {
			in.nextToken();
			mas[i] = (int)in.nval;
		}
		
		Arrays.sort(mas);
		int min = mas[0];
		int i = 1;
		
		while ((i < n)&&(min == mas[i])) {
			i++;
		}
		
		if (i < n) {
			output.write(Integer.toString(mas[i]));
		}
		else {
			output.write("NO");
		}
		input.close();
		output.close();
	}

}
