import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class C{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        long mod=1000000007l;
        int cases=sc.nextInt();


        while(cases>0)
        {
            cases--;
            Stack<Integer> stack=new Stack<>();

            int n=sc.nextInt();

            for(int j=0;j<n;j++)
            {
                int x=sc.nextInt();
                if(x==1)
                {
                    stack.add(1);
                }
                else
                {
                    int p=stack.pop();
                    if(p==x-1)
                    {
                        stack.add(x);
                    }
                    else {
                        while (p != x-1) {
                            p = stack.pop();
                        }

                        stack.add(x);

                    }

                }
                StringBuilder f=new StringBuilder();
                Stack<Integer> temp=new Stack<>();

                while(stack.isEmpty()==false)
                {
                    temp.add(stack.pop());
                }

                while(temp.isEmpty()==false)
                {
                    int z=temp.pop();
                    f.append(z+".");
                    stack.add(z);
                }


                System.out.println(f.substring(0,f.length()-1));

            }

        }

    }
}
