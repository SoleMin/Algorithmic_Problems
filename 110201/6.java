import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			int count=0;
			String str = input.nextLine();
			String num[] = str.split(" ");
			int nums[] = new int[num.length-1];
			for(int i =1;i<num.length;i++){
				nums[count++] = Integer.parseInt(num[i]);
			}
			
			if(jolly(nums) == true){
				System.out.println("Jolly");
			}
			else System.out.println("Not jolly");
		}
	}
	public static boolean jolly(int[] nums){
		int count =1;
		Boolean ret = true;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while(count<nums.length){
			int first = nums[nums.length-count];
			int second = nums[nums.length-++count];
			
			if(first>second){
					if(!arrayList.contains(first-second))
						arrayList.add(first-second);
			}
			else if(second>first){
				if(!arrayList.contains(second-first))
					arrayList.add(second-first);
			}
			else return false;
		}
		
		if(arrayList.size()!=(nums.length-1)) return false;
		
		Collections.sort(arrayList);
		
if(arrayList.size()==1) return true;
		else{
			for(int i =0;i<arrayList.size();i++){
				ret = ret&&(arrayList.get(i) ==(i+1));
			}
		}
		return ret;
		
	}
}