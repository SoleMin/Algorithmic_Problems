import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

	boolean test = false;
	PrintWriter pw = new PrintWriter(System.out);
	InputStreamReader inp = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(inp);
	
	private String[] inData = {"zzz"
			};
	
	
	static int id = -1;
	
	public String readLine() {
		id++;
		if (test)
			return inData[id];
		else
			try{
				return in.readLine();	
			} catch( Exception e){
				e.printStackTrace();
			}
		return "";
	}

	private void solve() {
		
		String readLine = readLine();
		
		int best = 0;
		
		for (int i = 0; i < readLine.length(); i++) {
			for (int j = i; j < readLine.length(); j++) {
				String substring = readLine.substring(i,j+1);
				String remainString = readLine.substring(i+1);
				if(remainString.contains(substring)){
					if(substring.length() > best){
						best = substring.length();	
					}
					
				}
			}
		}
		System.out.println(best);
	}
	
	public static void main(String args[]) throws Exception {

		new Main().solve();
    }

	
}