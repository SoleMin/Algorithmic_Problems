import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> dictionary = new ArrayList<String>();
		String error = "No solution.\n";
		 

		while(true){
         
			String input = scanner.nextLine();
			
			if(input.equals(""))
				break;
			
			dictionary.add(input);
		}
		
		ArrayList<String> input_line = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String input = scanner.nextLine();
			input_line.add(input);
		}
		String result ="";	
		for(String tmp : input_line){
			
			String[] list = tmp.split(" ");
				
			if(!dictionary.contains(list[0]) || !dictionary.contains(list[1])){
				result+=error;
				continue;
			}
			
			Queue<String> queue = new LinkedList<String>();
			int []parent = new int[dictionary.size()];
			int[] distance = new int[dictionary.size()];
			
			Arrays.fill(parent,-1);
			Arrays.fill(distance,59999);
			distance[dictionary.indexOf(list[0])]=0;
			queue.add(list[0]);
			int index=-1;
			
			while(!queue.isEmpty()){
				String now =queue.remove();
				int x = dictionary.indexOf(now);
				if(now.equals(list[1])){
					index=x;
					break;
				}
				
				for(int i=0; i<now.length(); i++){
					String copy = now;
					for(int j = 0; j < 26; j++){
						if(now.charAt(i)!='a'+j)
						{
							String next="";
							next+=copy.substring(0,i);
							next+= Character.toString((char)('a'+j));
							next+=copy.substring(i+1);
							int y = -1;
							y = dictionary.indexOf(next);
							if(y!=-1 && distance[y]==59999)
							{
								distance[y] = distance[x] + 1;
								parent[y] = x;
								queue.add(next);
							}	
						}
					}
				}		
			}
			
			if(index == -1){
				result += error;
			}
			else{
				Stack<String> bfs_stack = new Stack<String>();
				while(index!=-1)
				{
					bfs_stack.push(dictionary.get(index));
					index = parent[index];
				}
				while(!bfs_stack.isEmpty())
					result+= bfs_stack.pop() + "\n";
			}
			
			result+="\n";
		}
		System.out.print(result);
	}	
}