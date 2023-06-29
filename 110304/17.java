import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c = input.nextInt();
        input.nextLine();
        input.nextLine();
        String s = "the quick brown fox jumps over the lazy dog";
        try
        {
            for (int i = 0; i < c; i++) {
                int count =0;
                int checkcount=0;
                String[] text = new String[100];
                TreeMap<Character,Character> treeMap = new TreeMap<>();
                while(input.hasNextLine()){
                    text[count] = input.nextLine();
                    if (text[count].equals("\n")||text[count].equals("")){
                        break;
                    }
                    if (text[count].length() == s.length()&& checkcount ==0){
                        String a = "";
                        for (int j = 0; j < s.toCharArray().length ; j++) {
                            treeMap.put(text[count].charAt(j), s.charAt(j));
                            StringBuilder res2 = new StringBuilder();
                            res2.append(treeMap.get(text[count].charAt(j)));
                            a = res2.toString();
                        }
                        if (a.equals(s)){
                            checkcount++;
                        }
                    }
                    count++;
                }


                String[] strarr = new String[count];
                for (int k = 0; k < strarr.length; k++) {
                    StringBuilder res = new StringBuilder();
                    for (int j = 0; j < text[k].toCharArray().length; j++) {
                        res.append(treeMap.get(text[k].charAt(j)));
                        strarr[k] = res.toString();
                    }
                }
                boolean x = false;
                for (int j = 0; j < strarr.length; j++) {
                    if (strarr[j].equals(s)){
                        for (int k = 0; k < strarr.length; k++) {
                            System.out.println(strarr[k]);
                        }
                        x= true;
                        break;
                    }
                }
                if (!x) System.out.println("No solution.");
                System.out.println();
            }
        } catch (Exception e ){
            System.out.println("No solution.");
        }
        
    }
}
