import java.util.*;
public class IQ {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> e=new ArrayList<Integer>();
		ArrayList<Integer> o=new ArrayList<Integer>();
		int size=sc.nextInt();
		for(int w=0;w<size;w++)
		{
			int x=sc.nextInt();
			if(x%2==0)e.add(w+1);
			else o.add(w+1);
		}
		if(e.size()==1)System.out.println(e.get(0));
		else System.out.println(o.get(0));
		}
}
