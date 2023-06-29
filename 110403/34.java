import java.util.*;
public class Main {    
	public static int first(int[] dis, int len) {        
		int result = 0;        
		if (len <= 1)            
			result += dis[len];        
		else if (len == 2)            
			result += dis[1] + dis[0] + dis[2];        
		else {            
			int j;            
			for (j = len - 1; j >= 3; j = j - 2) {                
				if (dis[1] * 2 + dis[0] + dis[j] < 2 * dis[0] + dis[j] + dis[j - 1])                    
					result = result + 2 * dis[1] + dis[0] + dis[j];                
				else                    
					result = result + dis[j] + 2 * dis[0] + dis[j - 1];            
			}            
			if (j == 2)                
				result = result + dis[1] + dis[0] + dis[2];            
			else                
				result = result + dis[1];        
		}        
		return result;    
	}    
	
	public static void main(String[] args) {        
		Scanner sc = new Scanner(System.in);        
		int n = sc.nextInt();        
		sc.nextLine();        
		for (int i = 0; i < n; i++) {            
			sc.nextLine();            
			int len = sc.nextInt();            
			int[] dis = new int[len];            
			for (int j = 0; j < len; j++) {                
				dis[j] = sc.nextInt();            
			}            
			Arrays.sort(dis);            
			int result;            
			result = first(dis, len);            
			System.out.println(result);            
			System.out.println("");        
		}    
	}
}