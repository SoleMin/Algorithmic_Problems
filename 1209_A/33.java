
import java.util.ArrayList;
import java.util.Scanner;

public class PaintTheNumber {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		ArrayList<Integer> l=new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			l.add(sc.nextInt());
		}
		
		boolean c=false;
		
		
			for(int i=0; i<l.size(); i++) {
				if(l.get(i)==-1)
					continue;
				for(int j=0; j<l.size(); j++) {
					
					if(i==j || l.get(j)==-1)
						continue;
					else {
						if(l.get(j)%l.get(i)==0) {
							l.set(j, -1);
						}
					}
				}
			}
			
			int nbr=0;
			for(int i=0; i<l.size(); i++)
				if(l.get(i)!=-1)
					nbr++;
			System.out.println(nbr);
	}

}
