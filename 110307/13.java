import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static class Block{
		int previous = -1;
		int distance = Integer.MAX_VALUE;
		Block(){}
		public void setPre(int pre){
			previous = pre;
		}
		public void setDist(int dist){
			distance = dist;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> dic = new ArrayList<String>();
		String s;
		while(sc.hasNextLine()){
			s = sc.nextLine();
			if(s.length() == 0)
				break;
			dic.add(s);
		}
		
		while(sc.hasNextLine()){
			s = sc.nextLine();
			if(s.length() == 0)
				break;
			String start = s.split(" ")[0];
			String end = s.split(" ")[1];
			
			if(!dic.isEmpty() && (!dic.contains(start)|| !dic.contains(end))){
				System.out.println("No solution.");
				break;
			}
			
			Queue<String> que = new LinkedList<String>();
			ArrayList<Block> list = new ArrayList<Block>();
			
			int loca_end = -1;
			que.add(start);
			for(int i = 0; i < dic.size(); i++)
				list.add(new Main.Block());
			list.get(dic.indexOf(start)).setDist(0);
			
			while(!que.isEmpty()){
				String word = que.remove();
				
				int loca_word = dic.indexOf(word);
				if(word.equals(end)){
					loca_end = loca_word;
					break;
				}
				
				for(int i = 0; i < word.length(); i++){
					for(int k = 97; k < 123; k++){
						String tem = "";
						tem += word.substring(0, i);
						tem += (char)k;
						tem += word.substring(i+1, word.length());
						
						if(!tem.equals(word)){
							int index = dic.indexOf(tem);
							if(index > -1 && list.get(index).distance == Integer.MAX_VALUE){
								que.add(tem);
								list.get(index).setDist(list.get(loca_word).distance + 1);
								list.get(index).setPre(loca_word);
							}
						}
					}
				}
				
			}
			
			if(loca_end != -1){
				String result = "";
				while(loca_end > -1){
					result += dic.get(loca_end) + " ";
					loca_end = list.get(loca_end).previous;
				}
				
				String[] r = result.split(" ");
				for(int i = r.length-1; i >= 0; i--){
					System.out.println(r[i]);
				}
			}
			else{
				System.out.println("No solution.");
			}
			System.out.println();
			
		}
		
	}
}