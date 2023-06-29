import java.util.*;

class Main {
	
	/**
	 * 더블릿: 길이가 같고, 딱 한글자만 서로 다른 단어
	 */
	public static boolean isDoublets(String word1, String word2) {
		if (word1.length() != word2.length()) return false;
		
		int diff = 0;
		for(int i=0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) diff++;
			if (diff > 1) return false;
		}
		return (diff == 1);
	}
	
	public static void find(List<String> dict, String line) {
		
		String[] words = line.split(" ");
		
		if (!(dict.contains(words[0]) && dict.contains(words[1]))) {
			System.out.println("No solution.\n");
			return;
		}
		
		int[] parent = new int[dict.size()];
		boolean[] visited = new boolean[dict.size()];
		
		Arrays.fill(parent, -1);
		Arrays.fill(visited, false);
		
		Queue<String> queue = new LinkedList<>();
		
		visited[dict.indexOf(words[0])] = true;
		queue.add(words[0]);
		
		int index = -1;
		
		while (!queue.isEmpty()) {
			String current = queue.remove();
			int idx = dict.indexOf(current);
			
			if (current.equals(words[1])) {
				index = idx;
				break;
			}
			
			for(int i=0; i < dict.size(); i++) {
				String next = dict.get(i);
				if (!visited[i] && isDoublets(current, next)) {
					visited[i] = true;
					parent[i] = idx;
					queue.add(next);
				}
			}
		}
		
		if (index == -1) {
			System.out.println("No solution.\n");
			return;
		}
		
		Stack<String> stack = new Stack<>();
		while (index != -1) {
			stack.push(dict.get(index));
			index = parent[index];
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println();
	}
		
	public static void main(String[] args) throws Exception {
		
		List<String> dictionary = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line == null || line.length() == 0) break;
			dictionary.add(line);
		}
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line == null || line.length() == 0) break;
			
			find(dictionary, line);
		}
		input.close();
	}
}