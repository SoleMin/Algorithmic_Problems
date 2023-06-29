import java.util.*;
import java.io.*;

public class candies {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		int actions = file.nextInt();
		int left = file.nextInt();
		int start = 0;
		int c = 1;
		while (true) {
			start += c;
			if (c + (start - left) == actions) break;
			c++;
		}
		System.out.println(start - left);
	}

	public static void main(String[] args) throws Exception {
		new candies().run();
	}

}