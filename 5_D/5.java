import java.util.Scanner;

public class Main{
	static final double eps = 1e-10;
	public static void main(String []args){
		Scanner cin = new Scanner(System.in);
		double a,v;
		double l,d,w;
		double time;
		
		a = cin.nextDouble();
		v = cin.nextDouble();
		
		l = cin.nextDouble();
		d = cin.nextDouble();
		w = cin.nextDouble();
		
		if(v < w + eps)
		{
			double t1 = v / a;
			double len_bond = (v * v) / (2 * a);
			if(len_bond + eps > l)
			{
				time = Math.sqrt(2 * l / a);
			}
			else
			{
				double t2 = (l - len_bond) / v;
				time = t1 + t2;
			}
			System.out.println(time);
		}
		else
		{
			double len_bondv =  (v * v) / (2 * a);
			double len_bondw = (w * w) / (2 * a);
			if(len_bondw + eps > d)
			{
				if(len_bondv + eps > l)
					time = Math.sqrt(2 * l / a);
				else{
					double t1 = v / a;
					double t2 = (l - len_bondv) / v;
					time = t1 + t2;
				}
			}
			else
			{
				double len_bonds = (v * v - w * w) / (2 * a);
				
				if(len_bondv + len_bonds < d + eps)
					time = v / a + (d - len_bondv - len_bonds) / v + (v - w) / a;
				else
				{
					double f = Math.sqrt(d * a + w * w / 2);
					time = f / a + (f - w) / a;
				}
				if (len_bonds + eps > l - d) {
					double lv = Math.sqrt((l - d) * 2 * a + w * w);
					time += (lv - w) / a;
				} else {
					time += (v - w) / a + (l - d - len_bonds) / v;
				}
			}
			
			System.out.println(time);
		}
	}
}
		 					    	   	   	