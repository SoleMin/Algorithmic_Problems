import java.util.Scanner;

public class cf_contest_1177_problem_B {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        long k = s.nextLong();
        if (k<=9)
            System.out.println(k);
        else
        {

            int c = 1;
            while(k>c*((Math.pow(10,c)) - Math.pow(10,c-1)))
            {
                k-=c*((Math.pow(10,c)) - Math.pow(10,c-1));
//                System.out.println(k + " hello " + c);
                c++;
            }
//            System.out.println("k is " + k);
            long mo = k%c;

//            System.out.println("mo is " + mo);
            k = k/c;

            if (mo == 0) {
                mo = c;
                k--;
            }
            mo--;
//            k = Math.max(k-1,0);
//            System.out.println("k/c is " + k);
            long j = (long) (Math.pow(10,c-1) + k);

            String j1 = "" + j;
//            System.out.println("j1 is " + j1);
//            System.out.println("final ans= " + j1.charAt((int)mo));
//            System.out.println();
            System.out.println(j1.charAt((int)mo));
        }

    }
}
