import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
             String s = "Jolly";
            int num = input.nextInt();
            int[] newarray = new int[num];
            int[] seqarray = new int[num-1];
            for (int i = 0; i < num; i++) {
                newarray[i] = input.nextInt();
                if (i>0) {
                    seqarray[i-1] = Math.abs(newarray[i] - newarray[i-1]);
                }
            }
            for (int i = 0; i <  seqarray.length; i++) {
                int temp;
                for (int j = 0; j < seqarray.length-1; j++) {
                    if (seqarray[j] > seqarray[i]) {
                        temp = seqarray[i];
                        seqarray[i] = seqarray[j];
                        seqarray[j] = temp;
                    }
                }
            }
           
            for (int i = 0; i < num-1; i++) {
                if (seqarray[i] != i + 1) {
                    s = "Not jolly";
                }
            }
            System.out.println(s);
        }
	}
}