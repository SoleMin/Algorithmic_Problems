import java.io.*;
import java.util.*;
class Main {
	static String[] table,root;
	static int n;
	static boolean is_true = false;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<String> info = new ArrayList<>();
		
		while(sc.hasNextLine()) {
			info.add(sc.nextLine());
		}
		
		for(String str : info) {
			String[] s = str.split(" ");
			is_true = false;

			StringBuilder tem = new StringBuilder(String.format("%08d",Integer.parseInt(Integer.toBinaryString(Integer.parseInt(s[0])))));
			String[] id = tem.reverse().toString().split("");
			
			n = Integer.parseInt(s[1]);
			table = new String[n+2];
			root = s[2].split("");
			

			decode(id,1,0,0);
			
			if(is_true)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
			
		}
	}
	

	public static void decode(String[] id,int cur, int code,int cnt) {
		
		if(cnt == n-1) {
			if(isPossible(id,cur,code)) {
				is_true = true;
			}
			return;
		}
	
		
		if(code > 7)
			return;
		
		
		if(cnt == 0) {
			if(isPossible(id,cur,code)) {
				table[cur-1] = (((code & 4)>>2) + "");
				table[cur] = (((code & 2) >>1) + "");
				table[cur+1] = ((code & 1) + "");	
				decode(id,cur+1,Integer.parseInt(table[cur]+table[cur+1]+"0",2),cnt+1);		
				decode(id,cur+1,Integer.parseInt(table[cur]+table[cur+1]+"1",2),cnt+1);
			}	
			decode(id,cur,code+1,cnt);
		}
		else if((cnt == (n-3))) {
			table[n] = table[0];
			table[n+1] = table[1];
			table[cur+1] = ((code & 1) + "");
			if(isPossible(id,cur,code)) {
				decode(id,cur+1,Integer.parseInt(table[cur]+table[cur+1]+table[cur+2],2),cnt+1);
			}
			return;
		}
		else if((cnt == (n-2))) {
			table[n] = table[0];
			table[n+1] = table[1];
			if(isPossible(id,cur,code)) {
				decode(id,cur+1,Integer.parseInt(table[cur]+table[cur+1]+table[cur+2],2),cnt+1);	
			}
			return;
		}
		else {
			if(isPossible(id,cur,code)) {
				table[cur+1] =  ((code & 1) + "");	
				decode(id,cur+1,Integer.parseInt(table[cur]+table[cur+1]+"0",2),cnt+1);		
				decode(id,cur+1,Integer.parseInt(table[cur]+table[cur+1]+"1",2),cnt+1);
			}	
			return;
		}
	}
	
	public static boolean isPossible(String[] id,int cur,int code) {
		return id[code].equals(root[cur-1]);
	}

}