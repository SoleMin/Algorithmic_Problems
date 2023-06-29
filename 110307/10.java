import java.util.*;

class Main {
	public static ArrayList<String> inputs = new ArrayList<>();
	public static ArrayList<String> find = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(output());
	}
	
	public static void input() throws Exception{
		Scanner in = new Scanner(System.in);
		while(true){
			String s = in.nextLine();
			if(s.equals("")){
				break;
			}
			inputs.add(s);
		}
		while(in.hasNextLine()){
			String s = in.nextLine();
			if(s.equals("")){
				break;
			}
			find.add(s);
		}
	}
	
	public static String output() throws Exception{
		int cycle, index, idx_i, idx_j, i, j;
		int indexing[][];
		String output, depart, arrive, prev, follow, temp;
		char c;
		Queue<String> q;
		
		cycle = 0;
		output = "";
		for(String s : find){
			depart = s.split(" ")[0];
			arrive = s.split(" ")[1];
			if(cycle!=0 && cycle!=find.size()){
				output += "\n";
			}
			if(!inputs.contains(depart) || !inputs.contains(arrive)){
				output += "No solution.\n";
				continue;
			}
			
			q = new LinkedList<>();
			q.offer(depart);
			
			indexing = new int[2][inputs.size()];
			Arrays.fill(indexing[0], -1);
			Arrays.fill(indexing[1], -1);
			indexing[1][inputs.indexOf(depart)] = 0;
			
			index = -1;
			
			while(!q.isEmpty()){
				prev = q.poll();
				idx_i = inputs.indexOf(prev);
				if(prev.equals(arrive)){
					index = idx_i;
					break;
				}
				for(i=0; i<prev.length(); i++){
					temp = prev;
					for(j=0; j<26; j++){
						c = (char)('a'+j);
						if(prev.charAt(i)!=c){
							follow = "";
							follow += temp.substring(0, i)+Character.toString(c)+temp.substring(i+1);
							idx_j = -1;
							idx_j = inputs.indexOf(follow);
							if(idx_j!=-1 && indexing[1][idx_j]==-1){
								indexing[1][idx_j] = indexing[1][idx_i]+1;
								indexing[0][idx_j] = idx_i;
								q.offer(follow);
							}
						}
					}
				}
			}
			
			if(index==-1){
				output += "No solution.\n";
			}
			else{
				Stack<String> stack = new Stack<>();
				while(index!=-1){
					stack.push(inputs.get(index));
					index = indexing[0][index];
				}
				while(!stack.isEmpty()){
					output += stack.pop()+"\n";
				}
			}
			cycle++;
		}
		return output;
	}
}