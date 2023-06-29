import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		LinkedList<String> dictionary = new LinkedList<String>();
		
		while(input.hasNextLine()){
			String line =input.nextLine();
			
			if(line.equals("")){
				break;
			}
			
			else{
				dictionary.add(line);
			}
		}
		
		Map<String, LinkedList<String>> doubletsTree = new HashMap<String, LinkedList<String>>();
		
		Iterator<String> dicit = dictionary.iterator();
		while(dicit.hasNext()){
			LinkedList<String> doubletsWords = new LinkedList<String>();
			
			String keyword = dicit.next();
			
			for(int i=0; i<keyword.length(); i++){
				for(char j='a'; j<='z'; j++){
					if(keyword.charAt(i) == j)
						continue;
					else{
						String doubletWord = keyword.substring(0, i) + j + keyword.substring(i + 1);
						doubletsWords.add(doubletWord);
					}
				}
			}
			doubletsTree.put(keyword, doubletsWords);
		}
		
		while(input.hasNextLine()){
			String tempS = input.nextLine();
			String[] words = tempS.split(" ");
			String start = words[0];
			String end = words[1];
			
			LinkedList<String> path = new LinkedList<>();
			Queue<LinkedList<String>> BFSq = new LinkedList<>();
			
			path.add(start);
			BFSq.add(path);
			
			while(BFSq.size() != 0){
				path = BFSq.poll();
				String node = path.peekLast();
				
				if(node.equals(end)){
					break;
				}
				
				else{
					LinkedList<String> valueList = doubletsTree.get(node);
					Iterator<String> listIt = valueList.iterator();
					
					while(listIt.hasNext()){
						LinkedList<String> newPath = new LinkedList<>();
						
						Iterator<String> itP = path.iterator();
						
						while(itP.hasNext()){
							newPath.add(itP.next());
						}
						
						String adjacent = listIt.next();
						
						if(dictionary.contains(adjacent) && !path.contains(adjacent)){
							newPath.addLast(adjacent);
							BFSq.add(newPath);
							continue;
						}
					}
				}
			}
			
			if(!path.contains(end)){
				System.out.println("No solution.");
			}
			else{
				while(path.peekFirst() != null){
					System.out.println(path.pollFirst());
				}
			}
			
			System.out.println();
		}
		input.close();
	}
}





























