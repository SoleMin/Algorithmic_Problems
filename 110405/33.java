import java.util.*;

class Work implements Comparable<Work>{
	private double day;
	private double pay;
	private int order;
	
	public Work(String day, String pay, int order){
		this.day = Double.parseDouble(day);
		this.pay = Double.parseDouble(pay);
		this.order = order;
	}
	public double div(){
		return pay/day;
	}
	public int getOrder(){
		return this.order;
	}
	public double getPay(){
		return this.pay;
	}
	public double getDay(){
		return this.day;
	}
	public int compareTo(Work work){
		if(work.div() > div()) return 1;
		else if(work.div() < div()) return -1;
		else{
			if(work.getDay() < this.day) return 1;
			else if(work.getDay() > this.day) return -1;
			else return 0;
		}
	}
}
class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int test_case = in.nextInt();
		in.nextLine();
		
		for(int i = 0; i < test_case; i++){
			ArrayList<Work> arr = new ArrayList<>();
			in.nextLine();
			int num = in.nextInt();
			in.nextLine();
			
			for(int j = 0; j < num; j++){
				String[] s = in.nextLine().split(" ");
				Work w = new Work(s[0], s[1], j+1);
				arr.add(w);
			}
			
			Collections.sort(arr);
			
			for(int j = 0; j < num; j++){
				System.out.print(arr.get(j).getOrder() + " ");
			}
			System.out.println();
			System.out.println();
		}
		
	}
}