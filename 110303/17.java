import java.util.Scanner;
import java.util.*;
import java.util.Map;
import java.util.Set;

public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String firstWord = input.nextLine();
            String secondWord = input.nextLine();
            String[] firstarr = firstWord.split("");
            String[] secondarr = secondWord.split("");
            String abc = "abcdefghijklmnopqrstuvwxyz";
            ArrayList<String> resFarr = new ArrayList<>();
            ArrayList<String> resSarr = new ArrayList<>();
            ArrayList<String> res = new ArrayList<>();

            for (int j = 0; j < abc.toCharArray().length; j++) {
                int count = 0;
                for (int i = 0; i < firstarr.length; i++) {
                    if (Character.toString(abc.charAt(j)).equals(firstarr[i])) {
                        count++;
                        resFarr.add(Character.toString(abc.charAt(j)));
                    }
//                    if (Character.toString(abc.charAt(j)).equals(" ")||){
//
//                    }
                }
            }

            for (int j = 0; j < abc.toCharArray().length; j++) {
                int count = 0;
                for (int i = 0; i < secondarr.length; i++) {
                    if (Character.toString(abc.charAt(j)).equals(secondarr[i])) {
                        count++;
                        resSarr.add(Character.toString(abc.charAt(j)));
                    }
                }
            }


            for (int i = 0; i < firstarr.length ; i++) {
                for (int k = 0; k < secondarr.length; k++) {
                    if (firstarr[i].equals(secondarr[k])){
                        res.add(firstarr[i]);
                        firstarr[i] = " ";
                        secondarr[k] = " ";
                        break;
                    }
                }
            }
            for (int j = 0; j < abc.toCharArray().length; j++) {
                for (int i = 0; i < res.size(); i++) {
                    if (Character.toString(abc.charAt(j)).equals(res.get(i))){
                        System.out.print(res.get(i));
                    }
                }
            }
            System.out.println();
        }
    }
}