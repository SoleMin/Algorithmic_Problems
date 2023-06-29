import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int caseCount = Integer.parseInt(br.readLine());
	 
	 for(int i = 0; i < caseCount; i++) {
	 br.readLine();
	List<Integer> timeList = new ArrayList<>();
  int humanCount = Integer.parseInt(br.readLine());
	int times[] = new int[humanCount];
	
	for(int j = 0; j < humanCount; j++) {
	times[j] = Integer.parseInt(br.readLine());
	}
	
	Arrays.sort(times);
	
	for(int j = 0; j < humanCount; j++) {
	timeList.add(times[j]);
	}
	
	int count = humanCount;
	int time = 0;
	
	while(count>=4) {
	int a = timeList.get(0);
	int b = timeList.get(1);
	int c = timeList.get(count - 2);
	int d = timeList.get(count -1);
	
	int t1 = (2 * a) + c + d;
	int t2 = a + (2 * b) + d;
	
	if(t1 < t2) {
	time = time + t1;
	}
	else{
	time = time + t2;
	}
	
	timeList.remove(count - 1);
	count--;
	timeList.remove(count - 1);
	count--;
	}
	
	if(count == 3) {
	time = time + timeList.get(0) + timeList.get(1) + timeList.get(2);
	}
	else if (count == 2) {
	time = time + timeList.get(1);
	}
	else{
	time = time + timeList.get(0);
	}
	System.out.println(time);
	System.out.println();
	}
		
	}
}