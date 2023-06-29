import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int testcase=scan.nextInt();
		scan.nextLine();
		for(int T=0;T<testcase;T++) {
			scan.nextLine();
			String s1 = scan.nextLine();
			if(s1=="") break;
			int job = Integer.parseInt(s1);
			int t[]=new int[job];
			int s[]=new int[job];
			
			int result[]=new int[job];
			for(int i=0;i<job;i++) {
				t[i]= scan.nextInt();
				s[i]=scan.nextInt();
			}
			int tmp;
			for(int i=0;i<job;i++) 
				result[i]=i;
			for(int i=1;i<job;i++) {
				for(int j=0;j<job-i;j++) {
					if(t[result[j]]*s[result[j+1]]>t[result[j+1]]*s[result[j]]) {
						tmp=result[j];
						result[j]=result[j+1];
						result[j+1]=tmp;
					}
				}
			}
			for(int i=0;i<job-1;i++)
				System.out.print(result[i]+1+" ");
			System.out.println(result[job-1]+1+"\n");
			scan.nextLine();
			
		}
		scan.close();
	}
}
