
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _0238InfinityGauntlet {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String,String> stones = new HashMap<String,String>();
		stones.put("green","Time");
		stones.put("yellow","Mind");
		stones.put("orange","Soul");
		stones.put("purple","Power");
		stones.put("red","Reality");
		stones.put("blue","Space");
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			stones.remove(sc.nextLine());
		}
		System.out.println(stones.size());
		for(String s:stones.values()) {
			System.out.println(s);
		}
		
			

	}

}
