import java.io.*;
import java.util.*;
class Main {
	public static boolean Doublets(String a, String b){
		if(a.length()!=b.length()){
			return false;
		}else{
			int differ =0;
			
			for(int i=0; i<a.length(); i++){
				int chA= a.charAt(i);
				int chB= b.charAt(i);
				
				if(chA !=chB){
					differ ++;
				}
			}
			return differ ==1;
		}	
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ArrayList<String> word = new ArrayList<String>();
		
		while((line = br.readLine())!=null){
			if(line.length()==0){
				break;
			}
			word.add(line);
		}
		
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for(String s: word){
			map.put(s, new ArrayList<String>());
		}
		
		for(int i=0; i<word.size(); i++){
			String a=word.get(i);
			
			for(int j=i+1; j<word.size(); j++){
				String b=word.get(j);
				
				if(Doublets(a,b)){
					map.get(a).add(b);
					map.get(b).add(a);
				}
			} 
		}
		
		boolean first = true;
		
		while((line = br.readLine()) != null){
			String split[] = line.split(" ");
			
			if(split.length < 2){
				break;
			}
			String a= split[0];
			String b= split[1];
			
			Queue<String> q = new LinkedList<String>();
			HashMap<String, String> prev = new HashMap<String, String>();
			
			q.add(a);
			prev.put(a, "");
			boolean found = false;
			
			while(!q.isEmpty()){
				String s = q.poll();
				
				if(s.equals(b)){
					found = true;
					break;
				}else {
					for(String ss : map.get(s)) {
						if(!prev.containsKey(ss)){
							q.add(ss);
							prev.put(ss, s);
						}
					}
				}
			}
			
			if(first){
				first = false;
			}else{
				System.out.println();
			}
			if(found){
				Stack<String> stack = new Stack<String>();
				
				String s = b;
				
				while(s.length() > 0){
					stack.add(s);
					s = prev.get(s);
				}
				while(!stack.isEmpty()){
					System.out.println(stack.pop());
				}
			}else{
				System.out.println("No solution.");
			}
			
		}	
		
	}
}