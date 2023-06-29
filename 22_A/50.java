
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class One {
	InputStreamReader inp = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(inp);
	boolean test = false;

	// String[] inData = { "4", "A", "B", "C", "D", "A-B 1:1", "A-C 2:2",
	// "A-D 1:0", "B-C 1:0", "B-D 0:3", "C-D 0:3" };
	String[] inData = { "4","1 1 2" };

	static int id = -1;

	public String readLine() throws IOException {
		id++;
		if (test)
			return inData[id];
		else
			return in.readLine();
	}

	public void solve() throws Exception {
		readLine();
		String readLine = readLine();
		
		String[] split = readLine.split(" ");
		List<Integer> ints = new ArrayList<Integer>();
		
		for (int i = 0; i < split.length; i++) {
			ints.add(Integer.valueOf(split[i]));
		}
		
		Collections.sort(ints);
		Integer object = ints.get(0);
		for (int i = 0; i < split.length; i++) {
			if(ints.get(i).compareTo(object) > 0){
				System.out.println(ints.get(i));
				return;
			}
		}
		System.out.println("NO");
	}

	public static void main(String[] args) throws Exception {

		new One().solve();

	}
}
