
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pttrung
 */
public class B {

    static Senator[] data;

    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int k = in.nextInt();
        int A = in.nextInt();
        data = new Senator[n];
        for (int i = 0; i < n; i++) {
            data[i] = new Senator(in.nextInt(), in.nextInt());
        }
        out.println(cal(0, new int[n], A, k));

        out.close();
    }

    public static double cal(int index, int[] num, int A, int left) {
        if (index == data.length - 1) {
            int dif = (100 - data[index].loyal)/10;
            dif = left >= dif? dif:left;
            num[index] =  dif;
           
            double result = 0;
            for (int k = 0; k < (1 << num.length); k++) {
                double val = 1;
                double total = 0;
                for (int i = 0; i < num.length; i++) {
                    if (((1 << i) & k) != 0) {
                        val *= ((double)(data[i].loyal + 10*num[i])/100);
                    } else {
                        val *= ((double)(100 - (data[i].loyal + 10*num[i]))/100);
                        total += data[i].level;
                    }
                }
                if (countBit(k) > num.length / 2) {
                    result += val;
                } else {
                    result += val * ((double) A / (A + total));
                }
            }
//           // if(result >= 1){
//                for(int i : num){
//                    System.out.print(i + " ");
//                }
//                System.out.println("\n" + result);
//            //}
            return result;
        } else {
            double result = 0;
            for (int i = 0; i <= left; i++) {
                if (i * 10 + data[index].loyal <= 100) {
                    num[index] = i;
                  //  double val = cal(index + 1 , num , A, left - i);
                    
                    result = Math.max(result, cal(index + 1, num, A, left - i));
                } else {
                    break;
                }
            }
            return result;
        }
    }

    public static int countBit(int val) {
        int result = 0;
        while (val > 0) {
            result += val % 2;
            val >>= 1;
        }
        return result;
    }

    public static class Senator {

        int level, loyal;

        public Senator(int level, int loyal) {
            this.level = level;
            this.loyal = loyal;
        }
    }

    public static boolean nextPer(int[] data) {
        int i = data.length - 1;
        while (i > 0 && data[i] < data[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = data.length - 1;
        while (data[j] < data[i - 1]) {
            j--;
        }
        int temp = data[i - 1];
        data[i - 1] = data[j];
        data[j] = temp;
        Arrays.sort(data, i, data.length);
        return true;
    }

    public static class Point {

        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public double pow(double a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        double val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val;
        } else {
            return val * val * a;
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
