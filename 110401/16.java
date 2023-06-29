import java.io.*;
import java.util.*;

public class Main{
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException{
		String buf;
		int testCase;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count, answer;
		buf = br.readLine();
		testCase =  Integer.parseInt(buf);
		
		for (int i = 0; i < testCase; i++){
			buf = br.readLine();
			st = new StringTokenizer(buf, " ");
			count = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			while(st.hasMoreTokens())
				list.add(Integer.parseInt(st.nextToken()));
			list.sort(Comparator.naturalOrder());
			answer = Answer(count/2);
			System.out.println(answer);
		}
	}
	public static int Answer(int pivet){
		int answer = 0;
		for (int i= 0; i < list.size(); i++)
			answer += Math.abs(list.get(i) - list.get(pivet));
		return answer;
	}
}