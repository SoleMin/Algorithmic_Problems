import java.util.*;
public class algo_2701
{
    public static void main(String args[])
    {
        Scanner ex=new Scanner(System.in);
        int n=ex.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=ex.nextInt();
        Arrays.sort(arr);
        int ans=0;
        int check[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(check[i]==0)
            {
                ans++;
                for(int j=i;j<n;j++)
                {
                    if(arr[j]%arr[i]==0)
                    check[j]=1;
                }
            }
        }
        System.out.println(ans);
    }
}