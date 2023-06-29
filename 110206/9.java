import java.io.*;
import java.util.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int tmp = testCase;
		StringBuilder sb = new StringBuilder();
		while(testCase-->0){
			sb.append("Scenario ").append(tmp-testCase).append('\n');
			Map<String, Integer> map = new HashMap<>();
			Map<Integer, Set<Integer>> edge = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int nameCount=0;
			for(int i=0; i<p; i++){
				st = new StringTokenizer(br.readLine(), ":");
				st = new StringTokenizer(st.nextToken(), ", ");
				
				List<Integer> list = new ArrayList<>();
				while(st.countTokens()>0){
					String name = st.nextToken()+", "+st.nextToken();
					if(map.get(name)==null){
						map.put(name, nameCount++);
						Set<Integer> set = new HashSet<>();
						edge.put(map.get(name), set);
					}
					list.add(map.get(name));
				}
				
				for(int j=0; j<list.size(); j++){
					for(int k=j+1; k<list.size(); k++){
						int tmp1 = list.get(j);
						int tmp2 = list.get(k);
						edge.get(tmp1).add(tmp2);
						edge.get(tmp2).add(tmp1);
					}
				}
			}
			
			Queue<Integer> queue = new LinkedList<>();
			int start=-1;
			if(map.get("Erdos, P.")!=null) start = map.get("Erdos, P.");
			
			if(start==-1){
				for(int i=0; i<n; i++){
					String name = br.readLine();
					sb.append(name).append(" infinity").append('\n');
				}
				continue;
			}
			
			for(int i=0; i<n; i++){
				String name = br.readLine();
				boolean visited[] = new boolean[10000001];
				boolean tf = false;
				int erdosNumber = 1;
				int nameNumber = 0;
				if(map.get(name)!=null) nameNumber = map.get(name);
				
				//
				
				Object[] edgeArray = edge.get(start).toArray();
				for(int j=0; j<edgeArray.length; j++){
					if((int) edgeArray[j]==nameNumber){
						tf = true;
						queue = new LinkedList<>();
						break;
					}
					queue.add((int) edgeArray[j]);
					visited[(int) edgeArray[j]] = true;
				}
				
				
				if(!tf) erdosNumber = 2;
				int qSize = queue.size();
				while(!queue.isEmpty()){
					int newStart = queue.poll();
					qSize--;
					edgeArray = edge.get(newStart).toArray();
					for(int j=0; j<edgeArray.length; j++){
						if((int) edgeArray[j]==nameNumber){
							tf = true;
							queue = new LinkedList<>();
							break;
						}
						if(!visited[(int) edgeArray[j]]){
							queue.add((int) edgeArray[j]);
							visited[(int) edgeArray[j]] = true;
						}
					}
					if(queue.isEmpty()) break;
					if(qSize==0){
						erdosNumber++;
						qSize = queue.size();
					}
				}
				
				if(tf) sb.append(name).append(" ").append(erdosNumber);
				else sb.append(name).append(" infinity");
				sb.append('\n');
				
				
				
			}
			
			
			
			
			
		}
		System.out.println(sb);
		
	}
}






// import java.io.*;
// import java.util.*;
// class Main {
// 	public static void main(String[] args) throws Exception {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int testCase = Integer.parseInt(br.readLine());
// 		int tmp = testCase;
// 		StringBuilder sb = new StringBuilder();
// 		while(testCase-->0){
// 			sb.append("Scenario ").append(tmp-testCase).append('\n');
// 			Map<String, Integer> map = new HashMap<>();
// 			// edge배열 >> i : startVertex, j : edgeCount, edge[i][j] : endVertex
// 			int[][] edge = new int[1001][1001];
// 			// name_edge_count 배열 >> i : startVertex, name_edge_count[i] : i(startVertex) 에서의 edge 개수
// 			int[] name_edge_count = new int[1001];
// 			StringTokenizer st = new StringTokenizer(br.readLine());
// 			int p = Integer.parseInt(st.nextToken());
// 			int n = Integer.parseInt(st.nextToken());
// 			// 지금까지 나온 저자들의 이름 개수 (새로운 번호를 할당해주기 위한 카운트)
// 			int nameCount=1;
// 			for(int i=0; i<p; i++){
// 				st = new StringTokenizer(br.readLine(), ":");
// 				st = new StringTokenizer(st.nextToken(), ", ");
				
// 				// 한개의 논문에 대한 저자 이름(번호로) 저장. (list)
// 				List<Integer> list = new ArrayList<>();
// 				while(st.countTokens()>0){
// 					String name = st.nextToken()+", "+st.nextToken();
// 					if(map.get(name)==null) map.put(name,nameCount++);
// 					list.add(map.get(name));
// 				}
				
// 				// edge 배열에 간선들 저장.
// 				for(int j=0; j<list.size(); j++){
// 					for(int k=j+1; k<list.size(); k++){
// 						int tmp1 = list.get(j);
// 						int tmp2 = list.get(k);
						
// 						// 이미 있는 간선이면 추가하지않고 pass
// 						boolean tf = false;
// 						for(int l=0; l<name_edge_count[tmp2]; l++){
// 							if(edge[tmp2][l]==tmp1){
// 								tf = true;
// 								break;
// 							}
// 						}
// 						if(!tf) edge[tmp2][name_edge_count[tmp2]++] = tmp1;
// 						tf = false;
						
// 						//위와 동일
// 						for(int l=0; l<name_edge_count[tmp1]; l++){
// 							if(edge[tmp1][l]==tmp2){
// 								tf = true;
// 								break;
// 							}
// 						}
// 						if(!tf) edge[tmp1][name_edge_count[tmp1]++] = tmp2;
					
// 					}
// 				}
				
				
// 			}
			
// 			Queue<Integer> queue = new LinkedList<>();
// 			int start = map.get("Erdos, P.");
			
			
// 			for(int i=0; i<n; i++){
// 				String name = br.readLine();
// 				boolean visited[] = new boolean[1001];
// 				// erdosNumber 를 찾았는지 여부 tf
// 				boolean tf = false;
// 				int erdosNumber = 1;
// 				// 입력받은 이름에 할당된 번호.
// 				int nameNumber = 0;
// 				if(map.get(name)!=null) nameNumber = map.get(name);
				
// 				for(int j=0; j<name_edge_count[start]; j++){
// 					if(edge[start][j]==nameNumber){
// 						tf = true;
// 						queue = new LinkedList<>();
// 						break;
// 					}
// 					queue.add(edge[start][j]);
// 					visited[edge[start][j]] = true;
// 				}
				
// 				if(!tf) erdosNumber = 2;
// 				int qSize = queue.size();
// 				// erdosNumber 가 1이 아닌경우 BFS
// 				while(!queue.isEmpty()){
// 					int newStart = queue.poll();
// 					qSize--;
// 					for(int j=0; j<name_edge_count[newStart]; j++){
// 						if(edge[newStart][j]==nameNumber){
// 							tf = true;
// 							queue = new LinkedList<>();
// 							break;
// 						}
// 						if(!visited[edge[newStart][j]]){
// 							queue.add(edge[newStart][j]);
// 							visited[edge[newStart][j]] = true;
// 						}
// 					}
// 					if(queue.isEmpty()) break;
					
// 					if(qSize==0){
// 						erdosNumber++;
// 						qSize = queue.size();
// 					}
// 				}
				
// 				if(tf) sb.append(name).append(' ').append(erdosNumber);
// 				else sb.append(name).append(" infinity");
// 				sb.append('\n');
// 			}
// 		}
		
// 		System.out.println(sb);
		
		
		
		
		
		
		
		
// 	}
// }