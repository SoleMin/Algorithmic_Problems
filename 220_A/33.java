import java.util.*;
public class r220a {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> sort = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			int k = in.nextInt();
			list.add(k);
			sort.add(k);
		}
		
		Collections.sort(sort);
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(sort.get(i).intValue() != list.get(i).intValue())
				count++;
		}
		if(count != 2 && count != 0)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}
