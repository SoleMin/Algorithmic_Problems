import java.io.*;
import java.util.*;

public class Solution{


    void solve()throws Exception
    {

        int n=nextInt();

        int[]a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=nextInt();

        ArrayList<Integer>list=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            list.add(a[i]);
        Collections.shuffle(list);
        int[]b=new int[n];
        for(int i=0;i<n;i++)
            b[i]=list.get(i);
        Arrays.sort(b);
        int cnt=0;
        for(int i=0;i<n;i++)
            if(a[i]!=b[i])
                cnt++;
        if(cnt<=2)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    private void mySort(int[] a) {
        if(a.length<=1)
            return;
        int n=a.length;
        int[]left=new int[n/2];
        int[]right=new int[n-n/2];
        for(int i=0;i<n;i++)
            if(i<left.length)
                left[i]=a[i];
            else
                right[i-left.length]=a[i];
        mySort(left);
        mySort(right);
        int i=0;
        int j=0;
        while (i<left.length || j<right.length)
        {
            if(i==left.length)
                a[i+j]=right[j++];
            else if(j==right.length)
                a[i+j]=left[i++];
            else if(left[i]<right[j])
                a[i+j]=left[i++];
            else
                a[i+j]=right[j++];
        }

    }

    ////////////
    BufferedReader reader;
    PrintWriter writer;
    StringTokenizer stk;
    void run()throws Exception
    {

        reader=new BufferedReader(new InputStreamReader(System.in));
        // reader=new BufferedReader(new FileReader("input.txt"));
        stk=null;
        //writer=new PrintWriter(new PrintWriter(System.out));
        //writer=new PrintWriter(new FileWriter("output.txt"));
        solve();
        reader.close();
        //writer.close();
    }
    int nextInt()throws Exception
    {
        return Integer.parseInt(nextToken());
    }

    long nextLong()throws Exception
    {
        return Long.parseLong(nextToken());

    }
    double nextDouble()throws Exception
    {
        return Double.parseDouble(nextToken());


    }

    String nextString()throws Exception
    {
        return nextToken();
    }
    String nextLine()throws Exception
    {
        return reader.readLine();
    }
    String nextToken()throws Exception
    {
        if(stk==null || !stk.hasMoreTokens())
        {
            stk=new StringTokenizer(nextLine());
            return nextToken();

        }
        return stk.nextToken();
    }

    public static void main(String[]args) throws Exception
    {
        new Solution().run();
    }








}