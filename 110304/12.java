import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
		private static int count;
    private static String[] a;
    private static int[] key;
		static String keyword = "the quick brown fox jumps over the lazy dog";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int t = Integer.parseInt(br.readLine());
		 String tmp = br.readLine();
		 a = new String[100];
		 while (t-- > 0) {
		     count = 0;
		     boolean found = false;
		     while ((tmp = br.readLine()) != null && tmp.length() != 0) {
		  a[count] = tmp;
		if(found || match(tmp)) {
			  found = true;
		  }
		  count++;
		     }
		     if (found) {
		  print();
		     } else {
		  System.out.println("No solution.");
		     }
		     if (t > 0)
		  System.out.println();
		 }
		    }

		    public static void print() {
		    	int len=0;
		 for (int i = 0; i < count; i++) {
		    len = a[i].length();
		     for (int j = 0; j < len; j++) {
		  if (a[i].charAt(j) == ' ')
		      System.out.print(' ');
		  else
		      System.out.print((char) key[a[i].charAt(j) - 'a']);
		     }
		     System.out.println();
		 }
		    }

		    public static boolean match(String s) {
		 int len = s.length();
		 if (keyword.length() != len)
		     return false;
		 key = new int[26];
		 for (int i = 0; i < len; i++) {
		     int tmp = s.charAt(i) - 'a';
		     if (s.charAt(i) == ' ') {
		  if (keyword.charAt(i) != ' ')
		      return false;
		     }  
		     
		     else if (key[tmp] == 0)
		      key[tmp] = keyword.charAt(i);
		  else if (key[tmp] != keyword.charAt(i))
		      return false;
		     
		 }
		 return true;
		    }
		}