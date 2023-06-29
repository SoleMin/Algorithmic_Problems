import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> dictionary = new ArrayList<String>();
		String error = "No solution.\n";
		while (true) {
			String input = scanner.nextLine();
			if (input.equals(""))
				break;
			
			dictionary.add(input);
		}
		
		while (scanner.hasNextLine()) {
			ArrayList<String> input_line = new ArrayList<String>();
			String input = scanner.nextLine();
			if (input.equals(""))
				break;
			input_line.add(input); // 여기서 단어 쌍 입력.
			
			for (String tmp : input_line) {
				String[] list = tmp.split(" "); // 입력받은 단어 쌍 분리.
				BFS(dictionary, list[0], list[1]);
			}
		}
	}
	
	public static boolean isDoublet (String now, String found) {
		if (now.length() != found.length()) {
			return false;
		}
		int cnt = 0;
		
		for (int i = 0; i < now.length(); i++) {
			if (now.charAt(i) != found.charAt(i)) {
				cnt++;
			}
			if (cnt > 1) {
				return false;
			}
		}
		return cnt == 1;
	}
	
	public static void BFS (ArrayList<String> dictionary, String start, String end) {
		Queue<String> queue =  new LinkedList<String>();
		boolean[] visited = new boolean[dictionary.size()];
		int[] routes = new int[dictionary.size()];
		
		Arrays.fill(visited, false);
		Arrays.fill(routes, -1);
		queue.add(start);
		
		int idx = -1;
		
		while (!queue.isEmpty()) {
			String now = queue.remove();
			
			if (Objects.equals(now, end)) {
				idx = dictionary.indexOf(now);
				break;
			}
			
			for (int i = 0; i < dictionary.size(); i++) {
				if (isDoublet(now, dictionary.get(i)) && !visited[i]) {
					visited[i] = true;
					routes[i] = dictionary.indexOf(now);
					queue.add(dictionary.get(i));
				}
			}
		}
		
		if (idx == -1) {
			System.out.println("No solution.\n");
			return;
		}
		
		Stack<String> bfs_stack = new Stack<String>();
		int first = dictionary.indexOf(start);
		int last = dictionary.indexOf(end);
		
		while (first != last) {
			bfs_stack.push(dictionary.get(last));
			last = routes[last];
		}
		
		System.out.println(start);
		while (!bfs_stack.isEmpty())
			System.out.println(bfs_stack.pop());
		System.out.println();
	}
}