import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Main {
	
	static int p,n;
	static String[][] names;
	static Map<String, Integer> hashmap;
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int t=input.nextInt();
		for(int i=0; i<t; i++){
			p=input.nextInt();
			n=input.nextInt();
			String[] name=new String[n];
			names=new String[p][];
			hashmap=new HashMap<String, Integer>();
			input.nextLine();
			
			for(int j=0; j<p; j++){
				String[] s=(input.nextLine().split(":")[0]).split("\\., ");
				for(int k=0; k<s.length-1; k++){
					s[k]+=".";
				}
				names[j]=s;
			}
			
			for(int x=0; x<n; x++){
				name[x]=input.nextLine();
			}

			bfs("Erdos, P.");
			
			System.out.println("Scenario "+(i+1));
			for(int a=0; a<n; a++){
				System.out.print(name[a]+" ");
				if(hashmap.containsKey(name[a]))
					System.out.println(hashmap.get(name[a]));
				else
					System.out.println("infinity");
			}
		}
		input.close();	
	}
	
	public static void bfs(String s){
		Queue<String> q=new ArrayDeque<String>();
		q.offer(s);
		hashmap.put(s, 0);
		
		while(!q.isEmpty()){
			String now=q.poll();

			for(int i=0; i<p; i++){
				for(int j=0; j<names[i].length; j++){
					if(names[i][j].equals(now)) {
						for(int k=0; k<names[i].length; k++){
							if((!hashmap.containsKey(names[i][k]))){
								q.offer(names[i][k]);
								hashmap.put(names[i][k],hashmap.get(now)+1);
							}
						}
					}
				}
			}
			
		}
	}
}