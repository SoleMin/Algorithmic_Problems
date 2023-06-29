import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemA {
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line = s.readLine();
		int len = line.length();
		int max = 0;
		for (int i = 0 ; i < len ; i++) {
			for (int j = i+1 ; j <= len ; j++) {
				String sch = line.substring(i, j);
				for (int k = i+1 ; k + (j - i) <= len ; k++) {
					String tch = line.substring(k, k+(j-i));
					if (sch.equals(tch)) {
						max = Math.max(max, (j-i));
					}
				}
			}
		}
		out.println(max);
		out.flush();
	}


	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}