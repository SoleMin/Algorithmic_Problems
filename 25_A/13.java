import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ProblemA {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		int n = Integer.parseInt(reader.readLine());
		String [] split = reader.readLine().split("\\s+");
		int value;
		int [] count = new int[2];
		int [] pos = new int[2];
		for(int i = 0; i < split.length; i++){
			value = Integer.parseInt(split[i]);
			count[value % 2] ++;
			pos[value % 2] = i + 1;
		}
		writer.println((count[0] == 1) ? pos[0] : pos[1]);
		writer.flush();
		writer.close();
	}

}
