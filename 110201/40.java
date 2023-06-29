import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int size;
		int[] inputArray;
		String inputString;
		String[] inputArr;

		while(input.hasNextLine()){
			Set<Integer> inputSet = new HashSet<>();
			Set<Integer> subSet = new HashSet<>();
			Set<Integer> resultArr = new HashSet<>();
			
		inputString=input.nextLine();
		inputArr= inputString.split(" ");

		inputArray = Arrays.stream(inputArr)
			.mapToInt(Integer::parseInt)
			.toArray();
		
		size = inputArray[0];
			for(int i =1 ; i<size; i++){
				inputSet.add(i);
			}
		
		if(size <= 2){
			System.out.println("Jolly");
		}else{
			for(int i = 1; i <= size; i++){
				// inputSet.add(inputArray[i]);
				if(i == size){
					break;
				}
					subSet.add(Math.abs(inputArray[i]-inputArray[i+1]));
			}
			inputSet.removeAll(subSet);
			
			if(inputSet.size()>0){
				System.out.println("Not jolly");
			}else
				System.out.println("Jolly");
		}
	}
}
}