
import java.io.*;
import java.util.*;
import java.text.*;

public class FollowTrafficRules
{
	public Scanner in = new Scanner(System.in);
	public PrintStream out = System.out;

	public double len, d, w, vmax, a;
	
	DecimalFormat fmt = new DecimalFormat("0.0000000000000000");
	
	public void main()
	{
		a = in.nextDouble();
		vmax = in.nextDouble();
		len = in.nextDouble();
		d = in.nextDouble();
		w = in.nextDouble();
		
		out.println(fmt.format(T()));
	}//end public void main()
	
	public double T()
	{
		double t, s;
		
		double t1, s1;
		t1 = vmax / a;
		s1 = vmax*vmax/(2.0*a);
		
		double t3, s3;
		t3 = w/a;
		s3 = w*w/(2.0*a);
				
		if(w >= vmax)
		{
			if(s1 < len)
			{
				return t1 + (len - s1)/vmax;
			}
			else
			{
				return Math.sqrt(2.0*len/a);
			}			
		}
		else
		{
			//w < vmax
			
			double t2, s2, v2;
			t2 = Math.sqrt(2.0*d/a);
			v2 = a*t2;
			
			double tx, vx;
			vx = Math.sqrt((2.0*a*d + w*w)/2.0);
			tx = vx / a;	
			
			//vmax > w

			//v2 > vx > w
			
			if(v2 < w)
			{
				if(v2 > vmax)
				{
					//v2 > vmax > w
					if(vmax > vx)
					{
						return tx + (vx - w)/a + T2(w);
					}
					else
					{
						double ty, sy;
						ty = (vmax - w)/a;
						sy = ty * (vmax + w)/2.0;
						return t1 + ty + (d - s1 - sy)/vmax + T2(w);
					}
				}
				else
				{
					//v2 < w, v2 <= vmax
					return t2 + T2(v2);					
				}
			}
			else if(v2 > vmax) //v2 >= w, vmax > w
			{
				//v2 > vmax > w
				if(vmax > vx)
				{
					return tx + (vx - w)/a + T2(w);
				}
				else
				{
					double ty, sy;
					ty = (vmax - w)/a;
					sy = ty * (vmax + w)/2.0;
					return t1 + ty + (d - s1 - sy)/vmax + T2(w);
				}
			}
			else  //vmax >= v2 >= w
			{
				//out.println("Questionable.");
				//return binary() + T2(w);
				
				//return  t3 + (d-s3)/w + T2(w);

				return tx + (vx - w)/a + T2(w);
			}
		}
	}
	
	public double binary()
	{
		double low, high, t, s;
		low = 0.0; high = vmax/a;
		
		for(int c=0;c<50;++c)
		{
			t = (low+high)/2;
			s = (a*t*t)/2 + ((a*t - w)/a)*(a*t + w)/2.0;
			
			if(s > d) high = t;
			else low = t;
		}
		t = (low+high)/2;
		return t + (a*t - w)/a;
	}
	
/*
	public double T()
	{
		double t1, s1, tx, sx, vx, ty, vy, sz, tz;
		t1 = vmax / a;
		s1 = a*t1*t1 / 2.0;
		
		vx = Math.sqrt((2.0*a*d + w*w)/2.0);
		tx = vx / a;
		
		if(s1 < d)
		{
			//reaches vmax
			if(vx < vmax)
			{
				//stops at vx
				return tx + (vx - w)/a + T2(w);
			}
			else //vx >= vmax
			{
				//stops at vmax
				if(w > vmax)
				{
					return t1 + (d - s1)/vmax + T2(vmax);
				}
				else
				{
					tz = (vmax - w)/a;
					sz = ((vmax + w)/2.0) * tz;
					
					return t1 + (d-sz-s1)/vmax + tz + T2(w);					
				}
			}
		}
		else //s1 >= d
		{
			//never reaches vmax
			vy = Math.sqrt(2.0*d*a);
			ty = vy / a;
			if(vx < vy)
			{
				//stops at vx
				return tx + (vx - w)/a + T2(w);
			}
			else //vx >= vy
			{
				if(w < vy)
				{
					return w/a + (d - w*w/(2.0*a))/w + T2(w);
				}
				else //w >= vy
				{
					//goes to vy, accelerate all the way
					return ty + T2(vy);		
				}
			}
		}
	}
*/	
	public double T2(double v0)
	{
		//v0 <= min(w, vmax)
		
		double t1, s1;
		t1 = (vmax - v0)/a;
		s1 = ((vmax + v0)/2.0)*t1;
		
		if(s1 < len-d)
		{
			//reaches vmax
			return t1 + (len-d-s1)/vmax;
		}
		else //s1 >= len - d
		{
			//does not reach vmax
			return (-v0 + Math.sqrt(v0*v0 + 2*a*(len-d)))/a;
		}
	}
	
	public static void main(String[] args)
	{
		(new FollowTrafficRules()).main();
	}
}