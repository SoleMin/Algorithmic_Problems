import java.io.*;
import java.util.*;


class Turtle implements Comparable<Turtle>{
	
	int weight;
	int hp;
	
	public int compareTo(Turtle t){
		int result =0;
		if(this.hp != t.hp){
			result = this.hp - t.hp;
		}
		else{
			result = this.weight - t.weight;
		}
		return result;
	}
	
}

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int result=0;
		ArrayList<Turtle> turtles = new ArrayList<Turtle>();
		
		while(scanner.hasNextInt()){
			int str1 = scanner.nextInt();
			int str2 = scanner.nextInt();
			scanner.nextLine();
			Turtle tmp = new Turtle();
			tmp.weight =str1;
			tmp.hp= str2;
			turtles.add(tmp);
		}
		int N = turtles.size();
		
		Collections.sort(turtles);


		int[] arr = new int[N+1];
		Arrays.fill(arr,10000000);
		arr[0]=0;
		
		
		for(int i=0; i<N; i++){
			for (int j=N; j>=0; j--){
				if((arr[j] + turtles.get(i).weight) <= turtles.get(i).hp){
					arr[j+1] = Math.min(arr[j+1], turtles.get(i).weight +arr[j]);
				}
			}
		}
		
		for(int i=0; i<N+1; i++){
			if(arr[i]<10000000)
				result =i;
		}
		
		System.out.println(result);
	}
}