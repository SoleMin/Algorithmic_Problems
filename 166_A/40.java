import java.util.Scanner;
import java.util.Arrays;

public class P166A 
{
	public static void main(String[] args) 
	{
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int k = myScanner.nextInt();
		Team[] queue = new Team[n];
		for (int i = 0; i < n; i++)
		{
			queue[i] = new Team(myScanner.nextInt(), myScanner.nextInt());
		}
		Arrays.sort(queue);
		
		int counter = 0;
		int i = 0;
		int p = -1;
		int t = -1;
		for (; i < k; i++)
		{
			if (p == queue[i].problems && t == queue[i].penalty)
				counter++;
			else
			{
				p = queue[i].problems;
				t = queue[i].penalty;
				counter = 1;
			}
		}
		for (; i < n; i++)
		{
			if (p == queue[i].problems && t == queue[i].penalty)
				counter++;
			else
				break;
		}
		System.out.println(counter);
	}

	static class Team implements Comparable<Team>
	{
		int problems;
		int penalty;
		
		public Team(int problems, int penalty)
		{
			this.problems = problems;
			this.penalty = penalty;
		}
		
		public int compareTo(Team t)
		{
			if (problems > t.problems) return -1;
			else if (problems < t.problems) return 1;
			else if (penalty > t.penalty) return 1;
			else if (penalty < t.penalty) return -1;
			else return 0;
		}
	}
}
