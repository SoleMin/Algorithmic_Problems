import java.io.*;
import java.util.*;

public class substring {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;
	public static void main(String[] args) throws IOException {
		InputStream input = System.in;
		//InputStream input = new FileInputStream("fileIn.in");
		OutputStream output = System.out;
		//OutputStream output = new FileOutputStream("fileOut.out");
		br = new BufferedReader(new InputStreamReader(input));
		out = new PrintWriter(output);
		String in = br.readLine();
      int len = in.length();
      int doub = len;
      boolean found = false;
      while (!found)
         {
         int count = 0;
         String[] parts = new String[len - doub + 1];
         for (int i = 0; i < len - doub + 1; i++)
            parts[i] = in.substring(i,i+doub);
         for (int i = 1; i < len - doub + 1; i++)
            for (int j = 0; j < i; j++)
               if (parts[i].equals(parts[j]))
                  count++;
         if (count >= 1)
            found = true;
         doub--;
         }
      out.println(doub+1);
		out.close();
	}
}
