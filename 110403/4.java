import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			br.readLine();
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> people = new ArrayList<>();
			for (int i = 0; i < n; i++)
				people.add(Integer.parseInt(br.readLine()));
			Collections.sort(people);
			int time = 0;
			while (people.size() > 0) {
				if (people.size() == 1) {
					time += people.get(0);
					break;
				} else if (people.size() == 2) {
					time += people.get(1);
					break;
				} else if (people.size() == 3) {
					time += people.get(0) + people.get(1) + people.get(2);
					break;
				} else if (people.size() > 3) {
					int case1 = people.get(1) * 2;
					int case2 = people.get(0) + people.get(people.size() - 2);
					if (case1 <= case2)
						time += people.get(0) + case1 + people.get(people.size() - 1);
					else
						time += people.get(0) + case2 + people.get(people.size() - 1);
					people.remove(people.size() - 2);
					people.remove(people.size() - 1);
				}
			}
			System.out.println(time+"\n");
		}
	}
}