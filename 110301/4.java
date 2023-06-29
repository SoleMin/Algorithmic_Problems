import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String keys = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

        
        while (input.hasNext()){
            String inputKeys = input.nextLine();
        
            String[] arrayKeys = inputKeys.split("");
            for (int i = 0; i < arrayKeys.length; i++) {
                for (int j = 0; j < keys.toCharArray().length; j++) {
                    if (arrayKeys[i].equals(Character.toString(keys.charAt(j)))) {
                        arrayKeys[i] = Character.toString(keys.charAt(j-1));
                    }
                }
            }

            for (int i = 0; i < arrayKeys.length; i++) {
                System.out.print(arrayKeys[i]);
            }
					System.out.println();
        }
       
    }
    
}