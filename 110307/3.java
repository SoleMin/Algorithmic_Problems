import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {

	// bfs알고리즘
	static final int INF = 50000;
	static TreeMap<String,Integer> map = new TreeMap<String,Integer>();
	static String[] unmap = new String[25200];
	static int[] parent, dist;
	static int N;
	
	static int bfs(String S, String T)
	{
		dist = new int[N];
		parent = new int[N];
		Arrays.fill(parent, -1);
		Arrays.fill(dist, INF);
		dist[map.get(S)] = 0;
		Queue<String> q = new LinkedList<String>();
		q.add(S);
		while(!q.isEmpty())
		{
			String cur = q.remove();
			int x = map.get(cur);
			if(cur.equals(T))
				return x;
			
			for(int i = 0; i < cur.length(); i++)
			{
				StringBuilder sb = new StringBuilder(cur);
				for(int j = 0; j < 26; j++)
					if(cur.charAt(i)!=j+'a')
					{
						String next = sb.replace(i, i+1, ""+(char)(j+'a')).toString();
						Integer y = map.get(next);
						if(y!=null && dist[y]==INF)
						{
							dist[y] = dist[x] + 1; // 그래프 업데이트
							parent[y] = x;
							q.add(next);
						}	
					}
					
			}
		}
		return -1;
	}
	   public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		      
		      // 사전 받기
		   	  boolean start = true;
		      int plus = 0;
		      int size = 0;
		      int qSize = 0;
		      int space = 0; // 사전과 질문단어 구분
		      String[] words = new String[25143];
		      String qWord = "";
		      String a = "";
		      while(input.hasNextLine()) {
		         a = input.nextLine();
		         if(a.equals("") && a.length() == 0 && size > 0 && space == 1) {
		            break;
		         }
		         else if(a.equals("") && a.length() == 0 && size > 0 && space == 0) {
		            space++;
		         }
		         else if(space == 0) { // 사전단어 넣기
		            words[size] = a;
		            size++;   
		         }
		         else if(space == 1) { // 질문단어 넣기
		            qWord += a + " ";
		            qSize++;
		         }
		      }
		      
		      // 질문단어 쪼개기
		      qSize *= 2;
		      String[] qWords = qWord.split(" ");
		      
		      // unmap에 사전단어 넣어주기
		      for(int i = 0; i < size; i++) {
		    	  unmap[N] = words[i];
		    	  map.put(words[i], N++);
		      }
		      
		      // map에 질문단어 넣어주면서 bfs찾기
			 		int lastSpace = 0;
		      String left = "";
		      String right = "";
		      String answer = "";
		      int stop = 0;
		      while(stop != (qSize/2)) {
						answer = "";
		    	  if(start) {
		    		  start = false;
		    	  }
		  else {
		    		  left = qWords[stop+plus];
		    		  right = qWords[stop+1+plus];
		    	  }
		    	  if(!map.containsKey(left) || !map.containsKey(right)) {
		    		  answer = "No solution.\n";
		    		  continue;
		    	  }
		    	  int index = bfs(left, right);
		    	  if(index == -1) {
		    		  answer = "No solution.\n";
		    	  }
		    	  else {
		    		  Stack<String> stack = new Stack<String>();
		    		  while(index != -1) {
		    			  stack.push(unmap[index]);
		    			  index = parent[index];
		    		  }
		    		  while(!stack.isEmpty()) {
		    			  answer += stack.pop() + "\n";
		    		  }
		    	  }
		    	  System.out.println(answer);
		    	  plus++;
		    	  stop++;
		      }
		      
		   }

		}