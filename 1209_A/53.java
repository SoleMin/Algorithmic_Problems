import java.util.*;

public class ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        ArrayList<Integer> ar=new ArrayList<>();

        for(int i=0;i<b;i++){
            ar.add(sc.nextInt());
        }

        Collections.sort(ar);
        int count=0;
        int i=0;
        while(ar.size()!=0)
        {
            int tmep=ar.get(i);
            int v=ar.remove(i);
            count++;
            int j=0;
            while(j<ar.size()){
                if(ar.get(j)%tmep==0){
                    int a=ar.remove(j);

                }
                else
                    j++;
            }

        }
        System.out.println(count);



    }
}
