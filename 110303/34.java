import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
   public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      while (scan.hasNextLine()) {
         String s1 = scan.nextLine();
         if (s1.equals(""))
            break;
         String s2 = scan.nextLine();
         
          HashSet<Character> saved =new HashSet<>();
         for (int i = 0; i < s1.length(); i++) {
            for(int j=0;j<s2.length();j++) {
               if(s1.charAt(i)==s2.charAt(j)) saved.add(s1.charAt(i));
            }
         }
         ArrayList<Character> ordered = new ArrayList<>(saved);
         Collections.sort(ordered);
         int repeat;
         int s1repeat;
         int s2repaet;
         for(int i=0;i<ordered.size();i++) {
        	 repeat=0;
        	 s1repeat=0;
        	 s2repaet=0;
        	 for(int j=0;j<s1.length();j++) 
        		 if(s1.charAt(j)==ordered.get(i)) s1repeat++;
        	 for(int j=0;j<s2.length();j++)
        		 if(s2.charAt(j)==ordered.get(i)) s2repaet++;
        	 repeat = s1repeat<s2repaet ? s1repeat:s2repaet;
        	 for(int j=0;j<repeat;j++)
        		 System.out.print(ordered.get(i));
         }
         System.out.println();
      }
   }
}