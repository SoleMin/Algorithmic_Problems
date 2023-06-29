import java.util.Scanner;

public class P_1177B {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long k = scan.nextLong();
		long k2 = k - 10;
		int cont = 1, pos;
		String out; //System.out.println(getString((int)k));
		
		if(k <= 9)
			System.out.println(k);
		else {
			cont++;
			while(k2 >= cont*(long)(Math.pow(10, cont)-Math.pow(10, cont-1))) {
				k2 -= cont*(long)(Math.pow(10, cont)-Math.pow(10, cont-1));
				cont++;
			}
			pos = (int)(k2%cont);
			k2 /= cont;
			k2 += (long)Math.pow(10, cont-1);
			out = String.valueOf(k2);
			System.out.println(out.charAt(pos));
		}	
	}
	
	/*public static String getString(int number) {
		int contador = 1;
		String salida = "";
		while(salida.length() <= number) {
			salida += contador;
			contador++;
		}
		return salida.substring(0, number);
	}*/
}
