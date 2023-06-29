import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		int testcase=input.nextInt();
		input.nextLine();
		input.nextLine();
		
		for(int i=0;i<testcase;i++){
			int n=input.nextInt();
			ArrayList<Integer> array=new ArrayList<Integer>();
			for(int j=0;j<n;j++){//입력받기
				array.add(input.nextInt());
				input.nextLine();			
			} 
			
			Collections.sort(array); //정렬
			int time=0;
			
			
			
			while(array.size()>=4){
				int t1=array.get(0)+array.get(0)+array.get(array.size()-2)+array.get(array.size()-1); //방법 첫번째
				int t2=array.get(0)+array.get(1)+array.get(1)+array.get(array.size()-1);//2번째 방법
				if(t1<t2)
					time+=t1;
				else
					time+=t2;	 
				array.remove(array.size()-1); //마지막 두개 삭제
				array.remove(array.size()-1);
			}
			
			if(array.size()==3){
				for(int j=0;j<3;j++)
					time+=array.get(j);
			}else 
				time+=array.get(array.size()-1);
			
			
			System.out.println(time);
			System.out.println();
		}
	}
}