import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	
	static ArrayList<Integer> a;
	static int result;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t=input.nextInt();
		for(int i=0; i<t; i++){
			int n=input.nextInt();
			a=new ArrayList<>();
		
			for(int j=0; j<n; j++){
				a.add(input.nextInt());
			}
			
			result=0;
			
			Collections.sort(a);
			
			while(!a.isEmpty()){
				sol();
			}
		
			System.out.println(result);
			System.out.println();
		}
		
		input.close();
	}
	
	public static void sol() {
		if(a.size()==3) {
			result+=a.get(0)+a.get(2);
			a.remove(2);
		}
		else if (a.size()<=2){
			result+=a.get(a.size()-1);
			a.clear();
		}
		else{
			if(a.get(1)*2<a.get(0)+a.get(a.size()-2)) {
				result+=a.get(0)+a.get(1)*2+a.get(a.size()-1);
			}
			else{
				result+=a.get(0)*2+a.get(a.size()-1)+a.get(a.size()-2);
			}
			a.remove(a.size()-1);
			a.remove(a.size()-1);
		}
	}
	
}