/*
(7 10)  1 2 3
(3, 7)
(1, 3)

(3, 7)
(3, 4)
(3, 1)
(2, 1)
(1, 1)
1

*/
import java.util.*;
public class CodeForcesW8P2 {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int tests = Integer.valueOf(sc.nextLine());


        while(tests > 0){
            int count = 0;
            String [] input = sc.nextLine().split(" ");
            int x = Integer.valueOf(input[0]);
            int y = Integer.valueOf(input[1]);


            if (x == y){
                count += 1;
            }
            else {
                if (x > y){
                    int temp = x;
                    x = y;
                    y = temp;
                }
                /*
                    (4, 17) 4 + 4
                    (1, 4)

                    (4, 16) 4
                    (4, 12)
                    (4, 8)
                    (4, 4)

                */
                while (x != 1 && x != 0 && y != 1){
                    count += (y / x);
                    int temp = x;
                    x = (y % x);
                    y = temp;
                }
                if (x != 0)
                    count += y;


            }



            System.out.println(count);
            tests --;
        }

    }
}
