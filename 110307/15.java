// import java.util.*;
// import java.util.*;


// class Main{
// 	static String[] dictionary;
// 	static int[] lastVisit;
// 	static int dictionarySize;
// 	static StringBuilder sb = new StringBuilder();
	
// 	public static void main(String[] args)throws IOException{
		
		
		
		
		
		
		
		
		
		
// 	}
// }











import java.io.*;
import java.util.*;
class Main {
	static String[] dictionary;
	static int[] lastVisit;
	static int dictionarySize;
	static StringBuilder sb = new StringBuilder();
	static boolean tf;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dictionary = new String[25143];
		dictionarySize = 0;
		while(true){
			String s = br.readLine();
			if(s.length()==0) break;
			
			dictionary[dictionarySize++] = s;
		}
		
		Arrays.sort(dictionary, 0, dictionarySize);		
		// for(int i=0; i<10; i++){
		// 	System.out.println(dictionary[i]);
		// }
		// System.out.println();
		
		while(true){
			StringTokenizer st;
			
			try{
				st = new StringTokenizer(br.readLine());
			}
			catch(NullPointerException e){
				break;
			}
			tf = false;
			lastVisit = new int[25143];
			Arrays.fill(lastVisit, -1);
			String start = st.nextToken();
			String end = st.nextToken();
			
			int startIndex = Arrays.binarySearch(dictionary, 0, dictionarySize, start);
			int endIndex = Arrays.binarySearch(dictionary, 0, dictionarySize, end);
			
			
			BFS(start, end);
			
			if(startIndex >= 0 && endIndex>=0 && lastVisit[endIndex]!=-1){
				List<String> list = new ArrayList<>();
				int index = endIndex;
				list.add(dictionary[index]);
				while(true){
					index = lastVisit[index];
					if(index==startIndex) break;
					list.add(dictionary[index]);
				}
				list.add(dictionary[startIndex]);
				
				
				for(int i=list.size()-1; i>=0; i--){
					sb.append(list.get(i)).append('\n');
				}
			}
			else if(!tf){
				sb.append("No solution.").append('\n');
			}
			sb.append('\n');
			
			
			
		}
		System.out.println(sb);
		
		
		
		
		
		
	}
	public static boolean isDoublet(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		int incorrect = 0;
		for(int i=0; i<s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(incorrect==0) incorrect++;
				else return false;
			}
		}
		return true;
	}
	
	
	public static void BFS(String start, String end){
		if(start.length() != end.length()){
			sb.append("No solution.").append('\n');
			tf = true;
			return;
		}
		
		int startIndex = Arrays.binarySearch(dictionary, 0, dictionarySize, start);
		int endIndex = Arrays.binarySearch(dictionary, 0, dictionarySize, end);
		

		
		if(startIndex < 0 || endIndex < 0){
			sb.append("no solution.").append('\n');
			tf = true;
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startIndex);
		
		lastVisit[startIndex] = startIndex;
		
		

		
		
		while(!queue.isEmpty()){
			startIndex = queue.poll();
			for(int i=0; i<dictionarySize; i++){
				if(isDoublet(dictionary[startIndex], dictionary[i]) && lastVisit[i]==-1){
					queue.add(i);
					lastVisit[i] = startIndex;
					if(i==endIndex) return;
				}
			}
			
			
		}
	}
}