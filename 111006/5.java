
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Main {
	public static int[] array;

	public static void main(String [] args) {
		Scanner input = new Scanner(new BufferedInputStream(System.in));

		int c = 0;
		while(true) {
			int n = input.nextInt();
			if(n == 0) break;

			array = new int[n];
			for(int i = 0; i < array.length; i++) {
				array[i] = i;
			}

			HashMap<String, Integer> map = new HashMap<String, Integer>();
			HashMap<Integer, String> map2 = new HashMap<Integer, String>();
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			
			input.nextLine();

			int count = 0;
			for(int i = 0; i < n; i++ ) {
				
				String name = input.nextLine();
				map2.put(count, name);
				map.put(name, count);
				count++;
			}
			int num = input.nextInt();
			input.nextLine();

			for(int i = 0; i < num; i++) {
				String s1 = input.next();
				String s2 = input.next();

				list1.add(map.get(s1));
				list2.add(map.get(s2));
			}

			int narray[] = new int[n+1];

			for(int k = -1; k < array.length; k++) {
				for(int i = 0; i < array.length; i++) {
					array[i] = i;
				}
				
				for(int i = 0; i < list1.size(); i++) {
					if(list1.get(i) == k||list2.get(i) == k) continue;
					array[root(list1.get(i))] = root(list2.get(i));
				}

				HashSet<Integer> r = new HashSet<>();
				for(int i = 0; i < array.length; i++) {
					r.add(root(i));
				}
				narray[k+1] = r.size();
			}

			ArrayList<String> split = new ArrayList<>();
			for(int i = 1; i < narray.length; i++) {
				if(narray[0] < narray[i]-1) 
					split.add(map2.get(i-1));
			}
			Collections.sort(split);

			if (c >= 1)
				System.out.println();
			System.out.println("City map #"+(c+1)+": "+split.size()+" camera(s) found");
			for(int i = 0; i < split.size(); i++)
				System.out.println(split.get(i));
			
			c++;
		}
	}
	public static int root(int i) {
		while(i != array[i]) {
			i = array[array[i]];
		}
		return i;
	}

}