import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CF1141F {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int[] terms = new int[n];
		int[] sums = new int[n+1];
		for(int i=0; i<n; i++) {
			terms[i] = Integer.parseInt(split[i]);
			sums[i+1] = sums[i]+terms[i];
		}
		ArrayList<Block> blocks = new ArrayList<>();
		for(int i=0; i<n; i++)
			for(int j=i; j<n; j++){
				int s = sums[j+1]-sums[i];
				blocks.add(new Block(i, j, s));
			}
		Collections.sort(blocks);
		ArrayList<Block> best = new ArrayList<>();
		int i = 0;
		while(i<blocks.size()){
			int curSum = blocks.get(i).sum;
			ArrayList<Block> curBlocks = new ArrayList<>();
			while(i<blocks.size() && blocks.get(i).sum==curSum) curBlocks.add(blocks.get(i++));
			int[] memo = new int[curBlocks.size()+1];
			Arrays.fill(memo, -1);
			memo[curBlocks.size()] = 0;
			for(int j=curBlocks.size()-1; j>=0; j--){
				int idx = Collections.binarySearch(curBlocks, new Block(curBlocks.get(j).r+1, curBlocks.get(j).r+1, curBlocks.get(j).sum));
				if(idx<0) idx = -(idx+1);
				memo[j] = Math.max(memo[j+1], 1+memo[idx]);
			}
			if(memo[0]>best.size()){
				best = new ArrayList<>();
				int idx = 0;
				while(memo[idx]>=1){
					if(memo[idx]>memo[idx+1]) best.add(curBlocks.get(idx));
					idx++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(best.size()).append("\n");
		for(Block b : best){
			sb.append(b.l+1).append(" ").append(b.r+1).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Block implements Comparable<Block>{
		int l, r, sum;
		
		Block(int a, int b, int c){
			l = a;
			r = b;
			sum = c;
		}

		@Override
		public int compareTo(Block o) {
			if(sum==o.sum){
				if(l==o.l) return r-o.r;
				return l-o.l;
			}
			return sum-o.sum;
		}
	}
}
