import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class order {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(in.readLine());
		Set<Integer> set = new TreeSet<Integer>();
		StringTokenizer st= new StringTokenizer(in.readLine());
		int a;
		List<Integer> list =new LinkedList<Integer>();
		while(st.hasMoreTokens()){
			a= Integer.parseInt(st.nextToken());
			if(!set.contains(a)){
				list.add(a);
				set.add(a);
			}
			
		}
		if(list.size()==1){
			out.println("NO");
		}else{
			Collections.sort(list);
			out.println(list.get(1));
		}
		out.close();
		System.exit(0);
	}
}
