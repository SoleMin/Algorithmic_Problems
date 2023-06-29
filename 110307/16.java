import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<String> dir = new ArrayList<>();
		List<String> word_list = new ArrayList<>();
		while(sc.hasNextLine()) {
			String word = sc.nextLine();
			if(word.equals(""))
				break;
			dir.add(word);
		}
		
		while(sc.hasNextLine()) {
			word_list.add(sc.nextLine());
		}
		
		for(String words : word_list) {
			String[] word = words.split(" ");
			String word1 = word[0];
			String word2 = word[1];
			
			if(!dir.contains(word1) || !dir.contains(word2)) {
				System.out.println("No solution.");
				System.out.println();
				continue;
			}
			boolean hasword1 = false;
	
			List<String> visit = new LinkedList<>();
				
			Map<String,String> v = new HashMap<>();
				
			Queue<String> bfs = new LinkedList<>();	
			
			bfs.add(word2);
			List<String> dir_copy = new ArrayList(dir);
			
			while(bfs.size() != 0) {
				
				if(hasword1)
					break;
					
				String parent = bfs.poll();
					
				visit.add(parent);
				dir_copy.remove(parent);

				for(Iterator<String> s = dir_copy.iterator();s.hasNext();) {

					String w = s.next();
					
					if(w.length() == parent.length()){
							
						int count = 0;
						for(int i = 0; i < w.length(); i++) {
							if(w.charAt(i) != parent.charAt(i)) {
								count += 1;
								if(count == 2)
									break;
							}
						}
						if(count == 1) {
							v.put(w,parent);
							if(w.equals(word1)) {
								hasword1 = true;
								break;
							}
							if(!visit.contains(w)) {
								bfs.add(w);
							}
						}
					}
				}
			}
			
			if(hasword1) {
				String ver = word1;
				while(!ver.equals(word2)) {
					System.out.println(ver);
					ver = v.get(ver);
				}
				System.out.println(ver);
			}
			else {
				System.out.println("No solution.");
			}
			System.out.println();
				
				
		
			
		}
			
		
		
		
	}
}