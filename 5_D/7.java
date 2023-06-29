import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class kresz {
	public static double a;
	public static double v;
	public static double l;
	public static double d;
	public static double w;
		
	public static double gyorsulut (double v1, double v2) { //v1 -> v2 mennyi utat tesz meg
		return Math.abs((v2*v2-v1*v1)/(2*a));
	}
	public static double gyorsulido (double v1, double v2) { //v1 -> v2 mennyi idő
		return Math.abs((v2-v1)/a);
	}
	
	
	public static void beolvas () throws IOException {
		Scanner be = new Scanner (new InputStreamReader (System.in));
			a = be.nextDouble();
			v = be.nextDouble();
			l = be.nextDouble();
			d = be.nextDouble();
			w = be.nextDouble();
		be.close();
	}
	
	
	public static void main (String args[]) throws IOException {
			beolvas();
			double s = l; //hátralévő út
			double t = 0; //eltelt idő
			
			if (v <= w ||  Math.sqrt(2*a*d) <= w) { //nincs korlátozás
				if (gyorsulut(0,v) > l) {
					t+=gyorsulido(0, Math.sqrt(2*a*l));
					s = 0;
				}
				else {
					s-=gyorsulut(0,v);
					t+=gyorsulido(0,v);
				}
			}
			else {
				
				//gyorsuló szakaszok a korlátozásig
				if (d < gyorsulut(0,v)+gyorsulut(v,w)) {
					double x = Math.sqrt(a*(d-w*w/(2*a))+w*w);
					s-=gyorsulut(0,w)+2*gyorsulut(w,x);
					t+=gyorsulido(0,w)+2*gyorsulido(w,x);
				}
				else {
					s-=gyorsulut(0,v)+gyorsulut(w,v);
					t+=gyorsulido(0,v)+gyorsulido(w,v);
				}
				
				//gyorsuló szakaszok a korlátozástól
				if (gyorsulut(v,w) > l-d) {
					double y = Math.sqrt(2*a*(l-d)+w*w);
					s-= gyorsulut(w,y);
					t+=gyorsulido(w,y);
				}
				else {
					s-=gyorsulut(w,v);
					t+=gyorsulido(w,v);
				}
			}
			
			t+=s/v; //nem gyorsuló szakaszok ideje
			
			System.out.println(t);
			
	}
	
}
