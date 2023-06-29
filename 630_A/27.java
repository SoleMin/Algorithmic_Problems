
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		new Main().run();
	}
	
	void run(){
		Locale.setDefault(Locale.US);
		try(Scanner in=new Scanner(System.in);
			PrintWriter out=new PrintWriter(System.out)){
			solve(in, out);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void solve(Scanner in, PrintWriter out) {
		String a=in.nextLine();
		out.println("25");
	}
	
}
