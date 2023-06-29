import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class Main {
    public static StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int read() throws IOException {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();
        for (int i=0; i<n; i++){
            String s=scanner.next();
            list1.add(s);
        }
        for (int i=0; i<n; i++){
            String s=scanner.next();
            list2.add(s);
        }
        for (int i=0; i<list1.size(); i++){
            for (int j=0; j<list2.size(); j++){
                if (list1.get(i).equals(list2.get(j))){
                    list1.remove(i);
                    list2.remove(j);
                    i--;
                    break;
                }
            }
        }
        System.out.println(list1.size());
    }
}