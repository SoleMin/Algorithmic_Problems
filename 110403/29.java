import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int test_case = in.nextInt();
		in.nextLine();
		for(int i = 0; i < test_case; i++){
			in.nextLine();
			int num = in.nextInt();
			in.nextLine();
			
			int result = 0;
			int[] people = new int[num];
			
			//사람들의 이동시간을 for문을 통해 입력 받음
			for(int j = 0; j < num; j++){
				people[j] = in.nextInt();
				in.nextLine();
			}
			
			Arrays.sort(people);
			int search = people.length - 2;
			for(int j = 0; j < people.length/2 - 1; j++){
				if(people[search] + people[0] > people[1]*2){
					result += (2*people[1] + people[search+1] + people[0]);
				}
				else{
					result += (people[search+1] + people[search] + + people[0] * 2);
				}
				search -= 2;
			}
			if((people.length & 1) == 1) result += (people[0] + people[1] +people[2]);
			else result += people[1];
			System.out.println(result);
			System.out.println();
		}
	}
}