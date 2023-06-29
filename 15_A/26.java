import java.util.*;

public class CottageVillage {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int side=sc.nextInt();
		ArrayList<Pair> lis=new ArrayList<Pair>();
		for(int x=0;x<size;x++)
		{
			lis.add(new Pair(sc.nextInt(), sc.nextInt()));
			
		}
		Collections.sort(lis);
		int count=2;
		for(int x=0;x<lis.size()-1;x++)
		{
			Pair a=lis.get(x);
			Pair b=lis.get(x+1);
			double na=a.x+a.len/2;
			double nb=b.x-b.len/2;
			//System.out.println(na+" "+nb);
			if(na<nb)
			{
				double dif=Math.abs(nb-na);
				if(dif==side)count++;
				else if(dif>side)count+=2;
			}
		}
		System.out.println(count);
	}
}
class Pair implements Comparable<Pair>
{
	int x;
	double len;

	public Pair(int a,int b)
	{
		x=a;
		len=b;
	}
	public int compareTo(Pair o) {
		return x-o.x;
	}
}
