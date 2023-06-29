import java.io.*;
import java.util.*;

class NumCase implements Comparable<NumCase>{
	public String num;
	int time;
	String inout;
	int dis;
	
	NumCase(String num, int time, String inout, int dis){
		this.num = num;
		this.time = time;
		this.inout = inout;
		this.dis = dis;
	}
	
	public int compareTo(NumCase s) {
		if (this.num.compareTo(s.num)>0 || (this.num.equals(s.num) && this.time>s.time)) {
			return 1;
		}
		else if (this.num.compareTo(s.num)<0  || (this.num.equals(s.num)&& this.time<s.time)) {
			return -1;
		}
		else{
			return 0;
		}
	}

}

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		scanner.nextLine();
		scanner.nextLine();
		
		for(int i=0; i<n ;i++){
			
			int []fee= new int[24];
			for(int j=0; j<24;j++){
				fee[j]= scanner.nextInt();
			}
			scanner.nextLine();
			ArrayList<NumCase> carInfo = new ArrayList<NumCase>();
			
			Map<String, Double> result = new TreeMap<String, Double>();
			
			while(scanner.hasNextLine()){
				String line= scanner.nextLine();
				if(line.equals(""))
					break;
				//System.out.println(num);
				String []line_sp = line.split(" ");
				String num= line_sp[0];
				result.put(num,0.00);
				String []tmp= line_sp[1].split(":");
				int time = Integer.parseInt(tmp[1])*24*60+Integer.parseInt(tmp[2])*60+Integer.parseInt(tmp[3]);
				String inout= line_sp[2];
				int dis= Integer.parseInt(line_sp[3]);
				NumCase o = new NumCase(num, time, inout, dis);
				carInfo.add(o);
			}
			
			Collections.sort(carInfo);

			for(String t : result.keySet()){
				
				int cost=0,pre=0,pre_time=0;
				
				for(NumCase tmp :carInfo ){
					if(!tmp.num.equals(t))
						continue;
					if(tmp.inout.equals("enter")){
						pre = tmp.dis;
						pre_time = tmp.time;
					}
					else if(tmp.inout.equals("exit") && pre!=0){
						int km = tmp.dis-pre;
						int panel = fee[(pre_time/60)%24];
						cost+= 100+Math.abs(km*panel);
						pre=0;
						pre_time=0;
						//System.out.println(t+" ->"+(cost+200)/100.00);
					}
					
				}
				if(cost!= 0)
					System.out.println(t+ " $"+String.format("%.2f", (cost+200)/100.00));
				
			}
			
			System.out.println("");
		}

	}
}