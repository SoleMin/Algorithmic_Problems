import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Main {
	public static Map<String, Integer> search(Map<String, ArrayList<String>> map,
																					 Map<String, Integer> en, 
																					 String s){
		Queue<String> que = new LinkedList<String>();
		Map<String, Boolean> visit = new HashMap<String, Boolean>();
		int count = 0;
		if(map.get(s) == null){
			en.put(s, count);
			return en;
		}
		int size = map.get(s).size();
		for(int i = 0; i < size; i++){
			que.add(map.get(s).get(i));
		}
		en.put(s, count);
		visit.put(s, true);
		
		while(!que.isEmpty()){
			count++;
			size = que.size();
			
			for(int k = 0; k < size; k++){
				s = que.peek();
				if(s == null)
					break;
				que.poll();
				if(visit.get(s) == null)
					visit.put(s, false);
				if(!visit.get(s)){
					visit.put(s, true);
					for(int i = 0; i < map.get(s).size(); i++)
						if(visit.get(map.get(s).get(i))==null)
							que.add(map.get(s).get(i));
					en.put(s, count);
				}
			}
		}
		return en;
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		Map<String, ArrayList<String>> map;
		Map<String, Integer> en;
		ArrayList<String> list;
		
		int p, n, i;
		String s;
		String[] name;
		
		int secnario = input.nextInt();
		for(int z = 1; z <= secnario; z++){
			map = new HashMap<String, ArrayList<String>>();
			en = new HashMap<String, Integer>();
			p = input.nextInt();
			n = input.nextInt();
			input.nextLine();
			for(i = 0; i < p; i++){
				s = input.nextLine().split(":")[0];
				name = s.split(", ");
				for(int k = 0; k < name.length; k++){
					if(k % 2 == 1)
						continue;
					String nameK=name[k]+", "+name[k+1];
					if(map.get(nameK) != null){
						list = map.get(nameK);
					}
					else
						list = new ArrayList<String>();
					for(int j = 0; j < name.length; j++)
						if(j != k && (j % 2 == 0))
							if(!list.contains(name[j]+", "+name[j+1]))
								list.add(name[j]+", "+name[j+1]);
					map.put(nameK, list);
				}
			}
			
			en = search(map, en, "Erdos, P.");
			
			System.out.println("Scenario " + z);
			for(i = 0; i < n; i++){
				s = input.nextLine();
				System.out.print(s + " ");
				if(en.get(s) == null)
					System.out.print("infinity");
				else
					System.out.print(en.get(s));
				System.out.println();
			}
		}
	}
}