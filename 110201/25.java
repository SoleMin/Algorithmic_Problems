import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		boolean is_jolly;
		while(scan.hasNextLine()){
			
			boolean[] compare = new boolean[3000];
			String s = scan.nextLine();
			if(s.length()==0) break;
			
			String[] S = new String[3000];
			int[] input = new int[3000];
			
			S=s.split(" ");
			int n= Integer.parseInt(S[0]);
			
			is_jolly=true;
			int index=0;
			for(int i=0;i<n;i++){
				input[i] = Integer.parseInt(S[i+1]);
			}
			for(int i=0;i<n;i++)
				if(i>0){
					index=Math.abs(input[i]-input[i-1]);
					if(index>=n||index==0) is_jolly=false;
					else compare[index]=true;
				}
			for(int i=1;i<n;i++){
				if(!is_jolly) break;
				if(!compare[i]) {is_jolly=false; break;}
			}
			System.out.println(is_jolly? "Jolly":"Not jolly");
		}
	}
}