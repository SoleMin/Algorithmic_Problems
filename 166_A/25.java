import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt() - 1 ;
        int a[][] = new int[n][2];
        for (int i = 0;i <n; i++) {
            a[i][0]=input.nextInt();
            a[i][1]=input.nextInt();
        }
        for (int i = 0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (a[i][0]<a[j][0]) {
                    int x=a[i][0];
                    int y=a[i][1];
                    a[i][0]=a[j][0];
                    a[i][1]=a[j][1];
                    a[j][0]=x;
                    a[j][1]=y;
                    
                }
            }
        }
        for (int i = 0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if ((a[i][1]>a[j][1])&&(a[i][0]==a[j][0])) {
                    int x=a[i][0];
                    int y=a[i][1];
                    a[i][0]=a[j][0];
                    a[i][1]=a[j][1];
                    a[j][0]=x;
                    a[j][1]=y;
                    
                }
            }
        }
        int x = a[k][0];
        int y = a[k][1];
        int s = 0;
        for (int i = 0; i<n; i++) {
            if ((a[i][0]==x)&&(a[i][1]==y)) {
                s++;
            }
        }
        System.out.println(s);
    }
}
