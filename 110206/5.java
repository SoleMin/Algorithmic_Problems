import java.util.*;

class Main {
	
	class Erdos {
		String name;
		int erdosNum;
		
		public Erdos(String name, int erdosNum) {
			this.name = name;
			this.erdosNum = erdosNum;
		}
	}
	
	HashMap<String, ArrayList<String>> map = new HashMap<>();
	
	HashMap<String, ArrayList<String>> getMap() {
		return map;
	}
	
	public int bfs(String start, String end) {
		Queue<Erdos> queue = new ArrayDeque<>();
		// Erdos e = new Erdos(start, 0);
		queue.add(new Erdos(start, 0));
		
		HashSet<String> addedToQueue = new HashSet<>();
		addedToQueue.add(start);
		
		while (queue.size() > 0) {
			Erdos curr = queue.poll();
			String currPerson = curr.name;
			int currErdosNum = curr.erdosNum;
			
			if (currPerson.equals(end)) {
				return currErdosNum;
			}
			
			if (map.get(currPerson) == null) {
				continue;
			}
			
			ArrayList<String> list = map.get(currPerson);
			for (int i=0; i < list.size(); i++) {
				String next = list.get(i);
				if (!addedToQueue.contains(next)) {
					queue.add(new Erdos(next, currErdosNum+1));
					addedToQueue.add(next);
				}
			}
		}
		
		
		return -1;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		int tc = Integer.parseInt(input.nextLine());
		
		for (int i=0; i < tc; i++) {
			Main erdosNumbers = new Main();
			HashMap<String, ArrayList<String>> map = erdosNumbers.getMap();
			int P = input.nextInt();
			int N = input.nextInt();
			input.nextLine();
			
			for (int j=0; j < P; j++) {
				String line = input.nextLine();
				String[] values = line.split(":");
				String[] values2 = values[0].split(", ");
				ArrayList<String> names = new ArrayList<>();
				for (int k=0; k < values2.length; k += 2) {
					names.add(String.format("%s, %s",values2[k],values2[k+1]));
				}
				for (int k=0; k < names.size(); k++) {
					String key = names.get(k);
					if (!map.containsKey(key)) {
						map.put(key, new ArrayList<String>());
					}
					for (int l=0; l < names.size(); l++) {
						if (l != k) {
							map.get(key).add(names.get(l));
						}
					}
				}
			}
			
			System.out.println("Scenario " + (i+1));
			for (int j=0; j < N; j++) {
				String query = input.nextLine();
				int erdosNum = erdosNumbers.bfs(query, "Erdos, P.");
				System.out.println(String.format("%s %s", query, erdosNum == -1 ? "infinity" : erdosNum));
			}
		}
		
		input.close();
	}
}