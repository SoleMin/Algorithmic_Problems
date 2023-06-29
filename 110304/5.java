import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        HashMap<Character, Character> map = new HashMap<>();
        String known = "the quick brown fox jumps over the lazy dog";

        int[] count = new int[26];
        for(int i = 0; i < known.length(); i++) {
            if(known.charAt(i) != ' ')
                count[known.charAt(i) - 97]++;
        }
        int tc = scan.nextInt();
        scan.nextLine();
        scan.nextLine();
        for(int tcNum = 0; tcNum < tc; tcNum++) {
            ArrayList<String> list = new ArrayList<>();
            map.clear();
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                if ("".equals(str)) {
                    break;
                }
                list.add(str);
            }

            String[] result;
            String key = findKey(list, count);
            if(!key.equals("")) {
                result = decode(map, known, key, list);
                for(int i = 0; i < result.length; i++) {
                    if(result[i] != null)
                        System.out.println(result[i]);
                }
            }
            else
                System.out.println("No solution.");
					System.out.println();
        }

    }
    private static String findKey(ArrayList<String> list, int[] count) {

        String key = "";
        Arrays.sort(count);

        for(int i = 0; i < list.size(); i++) {
            int[] count2 = new int[26];
            String str = list.get(i);
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) != ' ')
                    count2[str.charAt(j) - 97]++;
            }
            Arrays.sort(count2);
            if(Arrays.equals(count, count2)) {
                key = str;
                break;
            }
        }

        return key;
    }
    private static String[] decode(HashMap<Character, Character> map, String known, String key, ArrayList<String> list) {

        String[] result = new String[list.size()];
        for(int i = 0; i < known.length(); i++) {
            if(known.charAt(i) != ' ')
                map.put(key.charAt(i), known.charAt(i));
        }
        for(int i = 0; i < list.size(); i++) {
            String temp = "";
            String str = list.get(i);
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == ' ') {
                    temp += " ";
                }
                else {
                    temp += map.get(str.charAt(j));
                }
            }
            result[i] = temp;
        }
        return result;
    }
}