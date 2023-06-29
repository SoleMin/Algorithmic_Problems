
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int n, d, mungkin;
        mungkin = 2;
        n = user.nextInt();
        d = user.nextInt();

        int[] koordinat = new int[n];

        for (int i = 0; i < n; i++) {
            koordinat[i] = user.nextInt();

        }
        for (int i = 0; i < n-1 ; i++)
        {
            if (koordinat[i + 1] - koordinat[i] > d*2 )
            {
                mungkin += 2;
            }
            else if (koordinat[i + 1] - koordinat[i] == d*2 )
            {
                mungkin++;
            }

        }
        System.out.println(mungkin);
    }
}

	   		 	 			 		   		 			   	