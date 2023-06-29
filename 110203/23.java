import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int simul = input.nextInt();
		
		for(int k=0; k<simul; k++){
			int days = 0;
			int partys = 0;
			int hartalDays = 0;
			
			days = input.nextInt();
			partys = input.nextInt();
			
			int[] hartals = new int[days];
			HashSet<Integer> partyDays = new HashSet<Integer>();
			
			for(int i=0; i<partys; i++){
				partyDays.add(input.nextInt());
			}
			
			Iterator<Integer> it = partyDays.iterator();
			while(it.hasNext()){
				int day = it.next();
				
				for(int i=day-1; i<days; i+=day){
					if(i%7 < 5)
						hartals[i] = 1;
				}
			}
			for(int i=0; i<days; i++){
				if(hartals[i] == 1)
					hartalDays ++;
			}			
			System.out.println(hartalDays);
		}
		input.close();
	}
}