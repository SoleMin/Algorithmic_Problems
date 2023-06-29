import java.util.*;
public class Main {
	public static void main(String args[]) {
		//1 2 5 10
		Scanner scan = new Scanner(System.in);
		int Testcase = scan.nextInt();
		scan.nextLine();
		for(int t=0;t<Testcase;t++) {
			scan.nextLine();
			int person= scan.nextInt();
			scan.nextLine();
			int time[]=new int[person];
			for(int i=0;i<person;i++) {
				time[i]=scan.nextInt();
				scan.nextLine();
			}
			Arrays.sort(time);
			int sum=0;
			while(person>3) {
				int a= time[0]+2*time[1]+time[person-1];
				int b= 2*time[0]+time[person-2]+time[person-1];
				sum+= a>b ? b:a;
				person-=2;
			}
			if(person<=2)
				sum+=time[person-1];
			else 
				for(int i=0;i<person;i++) {
					sum+=time[i];
				}
			System.out.println(sum);
			System.out.println();
		}
	}
}
//알고리즘만 잘 짜보자구~
