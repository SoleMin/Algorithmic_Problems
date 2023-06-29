import java.util.*;


public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<int[]> elephant = new ArrayList<int[]>();
		ArrayList<int[]> elephantcopy = new ArrayList<int[]>();
		int[] impormation = new int[2];
		
		while(sc.hasNextInt()) {
			impormation[0] = sc.nextInt();
			impormation[1] = sc.nextInt();
			elephant.add(impormation.clone());
		}
		
		elephantcopy = (ArrayList<int[]>) elephant.clone();
		
		Collections.sort(elephant, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
		
		int[] dp = new int[elephant.size()];
		int[] next = new int[elephant.size()];
		
		int num = 0;
		int start = 0;
		
		for (int i = elephant.size() - 1; i > 0; i--) {
			dp[i] = 1;
			next[i] = -1;
			
			for (int j = i+1; j < elephant.size(); j++) {
				if (elephant.get(i)[1] > elephant.get(j)[1] && elephant.get(i)[0] < elephant.get(j)[0] && 1+dp[j] > dp[i]) {
					dp[i] = dp[j] + 1;
					next[i] = j;
				}
			}
			
			if (dp[i] > num) {
				num = dp[i];
				start = i;
			}
		}
		
		System.out.println(num);
		for(int i = start; i != -1; i=next[i]) {
			int temp = 0;
			for (int j = 0; j < elephant.size(); j++) {
				if (elephant.get(i)[0] == elephantcopy.get(j)[0]) {
					temp = j+1;
					break;
				}
			}
			System.out.println(temp);
		}
		
		sc.close();
	}
}
