import java.util.ArrayList;
import java.util.Scanner;

public class testD {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int i,j;
        i=input.nextInt();
        j=input.nextInt();
        ArrayList<String> m=new ArrayList<String>();
        input.nextLine();
        for(int k=0;k<i;k++){
            m.add(input.nextLine());
        }

        ArrayList<Integer> light = new ArrayList<Integer>();
        for(int k=0;k<j;k++){
            light.add(0);
        }

        for(int k=0;k<m.size();k++){
            for(int l=0;l<j;l++){
                if (m.get(k).charAt(l)=='1'){
                    light.set(l,light.get(l)+1);
                }
            }
        }
        for (int k=0;k<i;k++){
            if (is(light,j,m,k)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static Boolean is(ArrayList<Integer> light,int lightnum,ArrayList<String> button,int buttonnum){
                for(int j=0;j<lightnum;j++) {
                    if (button.get(buttonnum).charAt(j) == '1') {
                        if (light.get(j) - 1 == 0) {
                            return false;
                        }
                    }
                }
                return true;
    }
}

	  	    		 	 	 	 		 					 		 	