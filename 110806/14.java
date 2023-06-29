import java.util.Scanner;

public class Main {
    static int max = 32;
    static int n, identifier;
    static boolean possible;
    static int[] automata = new int[8], precell = new int[max], cell = new int[max + 1];

    static void backtrack(int a){
        if (a == n - 1){
            if (automata[precell[a-1] * 4 + precell[a] * 2 + precell[0]] == cell[a] && automata[precell[a] * 4 + precell[0] * 2 + precell[1]] == cell[0])
                possible = true;
            return;
        }
        for (int i = precell[a-1] * 4 + precell[a] * 2; i <= precell[a-1] * 4 + precell[a] * 2 + 1; i++){
            if (automata[i] == cell[a]){
                precell[a+1] = i % 2;
                backtrack(a + 1);
                if (possible)
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()){
            String[] input = scan.nextLine().split(" ");

            if (input[0].equals(""))
                break;

            identifier = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);

            for (int i = 0; i < n; i++){
                cell[i] = Integer.parseInt(String.valueOf(input[2].charAt(i)));
            }
            for (int i = 0; i < 8; i++){
                automata[i] = identifier % 2;
                identifier /= 2;
            }

            possible = false;
            for (int i = 0; i < 8; i++){
                if (automata[i] == cell[1]){
                    precell[0] = (i / 4) % 2;
                    precell[1] = (i / 2) % 2;
                    precell[2] = i % 2;
                    backtrack(2);
                    if (possible)
                        break;
                }
            }
            if (possible)
                System.out.println("REACHABLE");
            else
                System.out.println("GARDEN OF EDEN");
        }
    }
}