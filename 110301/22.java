import java.util.Scanner;

public class Main {
   public static void main(String args[]) {
      String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

      Scanner scan = new Scanner(System.in);

      while (scan.hasNextLine()) {
         String input = scan.nextLine();
         if(input.equals("")) break;
         String toupper = input.toUpperCase();
         for (int i = 0; i < toupper.length(); i++) {
            if (toupper.charAt(i) == ' ')
               System.out.print(" ");
            else if (toupper.charAt(i) == 'Q')
               System.out.print("Q");
            else if (toupper.charAt(i) == 'A')
               System.out.print("A");
            else if (toupper.charAt(i) == 'Z')
               System.out.print("Z");
            else if (toupper.charAt(i) == '`')
               System.out.print("`");
            else
               System.out.print(keyboard.charAt(keyboard.indexOf(toupper.charAt(i)) - 1));
         }
				System.out.println();
      }
   }
}