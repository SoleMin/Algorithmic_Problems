import java.util.*;

public class Subtractions {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int count = kb.nextInt();
		while(count > 0) {
			int smaller = kb.nextInt();
			int larger = kb.nextInt();
			int ops = 0;
			
			while(smaller > 0 && larger > 0) {
				if(smaller > larger) {
					int temp = smaller;
					smaller = larger;
					larger = temp;
				}
					
				ops += larger/smaller;
				larger = larger % smaller;
			}
			System.out.println(ops);
			count--;
		}

	}

}