import java.io.*;
import java.util.*;

public class Array224B {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] array = new int[n];
		int[] visited = new int[100002];
		st = new StringTokenizer(f.readLine());
		for(int i=0;i<n;i++){
			array[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		int begin = array[0];
		while(count<n && array[count] == begin){
			count++;
		}
		count--;
		int kcount = 1;
		visited[array[count]]++;
		int bindex = count;
		boolean good=true;
		count++;
		while(kcount<k){
			if(count==n){
				System.out.println("-1 -1");
				good=false;
				break;
			}
			if(visited[array[count]]==0){
				kcount++;
			}
			visited[array[count]]++;
			count++;
		}
		if(good&&k!=1){
		for(int i=bindex;i<count;i++){
			if(visited[array[i]]==1){
				break;
			}
			bindex++;
			visited[array[i]]--;
		}
		for(int i=count-1;i>bindex;i--){
			if(visited[array[i]]==1){
				break;
			}
			count--;
			visited[array[i]]--;
		}
		}
		if(k==1){
			System.out.println("1 1");
		}
		else if(good){
			System.out.println(bindex+1+" "+count);
		}
	}
}