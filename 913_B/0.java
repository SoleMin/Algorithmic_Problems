import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[10000]; //第i节点的父索引
        int b[] = new int[10000]; //该父索引有的子节点数目(不管符不符合条件，反正就是子节点)
        int c[] = new int[10000]; //该父索引有的子节点数目（满足云杉树条件的子节点）
        for(int i = 2; i <= n; i++)
        {
            a[i] = in.nextInt();
            b[a[i]]++;
        }
        for(int i = 2; i <= n; i++)
        {
            if(b[i] == 0)
                c[a[i]]++;
        }
        for(int i = 1; i <= n; i++)
        {
            if(c[i] != 0 && c[i] < 3)   //有子节点  但是不满足云杉树条件
            {
                System.out.println("No");
                System.exit(0);
            }
            if(b[i] != 0 && c[i] == 0)  //有子节点  但是都不符合条件  每个子节点还有子节点
            {
                System.out.println("No");
                System.exit(0);
            }
        }
        System.out.println("Yes");
    }
}

 	  	  	     	  	 	  	 			  	