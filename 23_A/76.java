import java.util.*;

public class A23 {
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	char[] input = sc.nextLine().toCharArray();
	int[][] dyn = new int[input.length][input.length];
	int max = 0;
	for(int a = 0; a < input.length; a++) {
	    for(int b = a + 1; b < input.length; b++) {
		if(input[a] == input[b]) {
		    int prev = (a == 0) ? 0 : dyn[a-1][b-1];
		    dyn[a][b] = prev + 1;
		    max = (dyn[a][b] > max) ? dyn[a][b] : max;
		}
	    }
	}
	System.out.println(max);
    }
}