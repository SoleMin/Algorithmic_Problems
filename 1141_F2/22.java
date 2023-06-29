import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static class Interval implements Comparable<Interval> {
		public int start , end;
		public Interval(int start , int end) {
			this.start = start;
			this.end = end;			
		}
		@Override
		public int compareTo(Interval interval) {
			return this.end - interval.end;			
		}		
	}
	
	private static int getTotal(List<Interval> list) {
		int ans = 0 , i , n = list.size();
		for (i = 0;i < n;i ++) {
			int end = list.get(i).end;
			while (i < n && list.get(i).start <= end) {
				i ++;				
			}
			i --;
			ans ++;
		}		
		return ans;
	}
	
	private static void solve(List<Interval> list) {
		List<int[]> ans = new ArrayList<>();
		int i , n = list.size();
		for (i = 0;i < n;i ++) {
			int start = list.get(i).start , end = list.get(i).end;
			while (i < n && list.get(i).start <= end) {
				i ++;				
			}
			i --;
			ans.add(new int[] {start , end});
		}
		System.out.println(ans.size());
		for (int[] array : ans) {
			System.out.println(array[0] + " " + array[1]);
		}
	}
	
	private static long[] a = new long[2000];	
	
	public static void main(String[] args) {																	
	
		Scanner scan = new Scanner(System.in);				

		Map<Long , List<Interval>> map = new HashMap<>();		
		int i , j , n = scan.nextInt() , max = 0;
		long ans = 0;
		for (i = 1;i <= n;i ++) {
			a[i] = scan.nextLong();
		}
		for (i = 1;i <= n;i ++) {
			long sum = 0;
			for (j = i;j <= n;j ++) {				
				sum += a[j];
				if (!map.containsKey(sum)) {
					map.put(sum , new ArrayList<>());
				}
				map.get(sum).add(new Interval(i , j));				
			}
		}
		for (List<Interval> list : map.values()) {
			Collections.sort(list);			
		}		
		for (Map.Entry<Long , List<Interval>> entry : map.entrySet()) {
			int total = getTotal(entry.getValue());
			if (total > max) {
				max = total;
				ans = entry.getKey();				
			}
		}
		solve(map.get(ans));		
	
	}
    
}


