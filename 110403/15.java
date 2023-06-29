import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		int testCase=sc.nextInt();
		List<Integer> left=new ArrayList<>();
		for(int i=0;i<testCase;i++){
			int totalTime=0;
			sc.nextLine();
			int n = sc.nextInt();
			for(int j=0;j<n;j++){
				left.add(sc.nextInt());
			}
			Collections.sort(left);
			while(left.size()>=4){
				int fastest=left.get(0);
				int secondFastest=left.get(1);
				int slowest=left.get(left.size()-1);
				int secondSlowest=left.get(left.size()-2);

				int option1=2*fastest+slowest+secondSlowest;
				int option2=fastest+2*secondFastest+slowest;
				if(option1<=option2){
					totalTime+=option1;
				}else{
					totalTime+=option2;
				}
				left.remove(left.size()-1);
				left.remove(left.size()-1);
			}
			if(left.size()==3){
				totalTime+=left.get(0);
				totalTime+=left.get(1);
				totalTime+=left.get(2);
			}else if(left.size()==2){
				totalTime+=left.get(1);
			}else{
				totalTime+=left.get(0);
			}
			System.out.println(totalTime);
			left.clear();
			System.out.println();
		}
		sc.close();
	}
}