
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(4);
		q.add(7);
		boolean luck = false;
		while(!q.isEmpty() && !luck)
		{
			int f = q.poll();
			if(a%f == 0)
			{
				luck = true;
				break;
			}
			if(f<a)
			{
				int t = (f+"").length();
				int tt = (int)Math.pow(10, t);
				q.add(tt*4+f);
				q.add(tt*7+f);
			}
		}
		if(luck)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

}
