import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			int num = sc.nextInt();
			int[] vitosFamily = new int[num];
			ArrayList<Integer> vitosSum = new ArrayList<>();
			
			for (int j = 0; j < num; j++) {
				vitosFamily[j] = sc.nextInt();
			}
			Arrays.sort(vitosFamily);
			
			int left = vitosFamily[0];
			int right = vitosFamily[vitosFamily.length-1];
			
			for (int idx = left; idx <= right; idx++) {
				int lefts = returnLefts(idx, vitosFamily);
				int rights = returnRights(idx, vitosFamily);
				
				vitosSum.add(lefts+rights);
			
			}
			System.out.println(Collections.min(vitosSum));
			
		}
	}
	public static int returnLefts(int idx, int[] vitosFamily){
		int num = 0;
		for(int i : vitosFamily){
			if(i == idx && num == 0) return 0;
			if(i == idx && num != 0) return num;
			if(i > idx) return num;
			num += (idx - i);
		}
		return num;
	}
	public static int returnRights(int idx, int[] vitosFamily){
		int num = 0;
		for(int i : vitosFamily){
			if(i == idx) continue;
			if(i < idx) continue;
			num += (i - idx);
			
		}
		return num;
	}
	public static int find(int[] arr, int target){
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] == target) return i;
		}
		return -1;
	}
	
}