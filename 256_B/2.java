import java.util.Scanner;
public class Problem {
    
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int side = input.nextInt()-1;
        int x = input.nextInt()-1;
        int y = input.nextInt()-1;
        long target = input.nextLong();
        
        
        int[] to_sides = {y, side - x, side - y, x};
        int[] to_corners = {(y+1)+(side-x+1),(side-x+1)+(side-y+1),(side-y+1)+(x+1),
            (x+1)+(y+1)};
        int min = Math.min(Math.min(y, x), Math.min(side - x, side - y));
        int[] after_pass = {1, 1, 1, 1};
        int[] corner_share = {1,1,1,1};
        int steps = 0 , i;
        long init = 1 ;
        int grown = 4;
        while (init < target) {
            init += grown;
            steps++;
            if (steps >= min) {
                for (i = 0; i < 4; i++) {
                    if (steps > to_sides[i]) {
                        init -= after_pass[i];
                        after_pass[i] += 2;
                    }
                    if (steps >= to_corners[i]){
                        init += corner_share[i]++;
                        //corner_share[i]++;
                    }
                }
            }
            grown += 4;
        }
        System.out.println(steps);
    }
}
