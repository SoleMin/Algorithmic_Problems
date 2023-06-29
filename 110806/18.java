import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
   static char cell[];
   static char precell[];
   static char automata[];
   static int n;
   static boolean possible;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String input = "";
      
      while ((input = br.readLine()) != null) {
         String numbers[] = input.split(" ");
         int identifier = Integer.parseInt(numbers[0]);
         n = Integer.parseInt(numbers[1]);
         
         String cells = numbers[2];
         
         cell = new char[33];
         precell = new char[32];
         automata = new char[8];
         possible = false;
         
         for (int i = 0; i < n; i++) {
            cell[i] = cells.charAt(i);
            cell[i] -= '0';
            //System.out.println(cell[i]);
         }
         
         
         
         for (int i = 0; i < 8; i++) {
            automata[i] = (char) (identifier % 2);
            identifier /= 2;
         }
         
         
         
         for (int i = 0; i < 8; i++) {
            if (automata[i] ==cell[1]) {
               precell[0] = (char) ((i / 4) % 2);
               precell[1] = (char) ((i / 2) % 2);
               precell[2] = (char) (i % 2);
               back(2);
               
               if (possible) {
                  break;
               }
            }
         }
         
         if (possible) {
            System.out.println("REACHABLE");
         }
         else {
            System.out.println("GARDEN OF EDEN");
         }
         
      }
   }
   
   static void back(int a) {
      if (a == n - 1) {
         if (automata[precell[a - 1] * 4 + precell[a] * 2 + precell[0]] == cell[a]
               && automata[precell[a] * 4 + precell[0] * 2 + precell[1]] == cell[0]) {
            possible = true;
         }
         return;
      }
      
      for (int i = precell[a - 1] * 4 + precell[a] * 2; i <= precell[a - 1] * 4 + precell[a] * 2 + 1; i++) {
         if (automata[i] == cell[a]) {
            precell[a + 1] = (char) (i % 2);
            back(a + 1);
            if (possible) {
               break;
            }
         }
      }
   }
   
   
   
   

}