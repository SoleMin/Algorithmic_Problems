import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
	     Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        String decoder ="the quick brown fox jumps over the lazy dog";
        input.nextLine();
        input.nextLine();
        ArrayList<HashMap<Character,Character>> maps =new ArrayList<>();
        ArrayList<ArrayList<String>> codelists = new ArrayList<>();

        
        StringBuffer decode2 = new StringBuffer("");
        for(int i =0;i<testCase;i++) {
            boolean out = false;
            String decode ="";
            ArrayList<String> codelist = new ArrayList<>();
            HashMap<Character,Character> map = new HashMap<>();
            codelist.clear();
        while (input.hasNextLine()){
                String code = input.nextLine();
                    if (code.trim().equals("")) break;
              codelist.add(code);
            }

            for(int j=0;j<codelist.size();j++){
                for(int k=0;k<26;k++) {
                    codelist.get(j).contains(Character.toString((char) (97 + k)));
                }
            }
            for(int j=0;j<codelist.size();j++){
                for(int k=0;k<26;k++) {
                   out= codelist.get(j).contains(Character.toString((char) (97 + k)));
                   if(out==false) break;
                }
                if(codelist.get(j).length()==decoder.length()&&out) {
                    decode = codelist.get(j);
                    if(j==codelist.size()-1&& decode.equals("")) map.clear();
                }
            }


            for(int j=0;j<decode.length();j++){
                map.put(decode.charAt(j),decoder.charAt(j));
            }
            HashMap<Character,Character> temp = new HashMap<>();
            for(int j=0;j<decode.length();j++){
                temp.put(decode.charAt(j),map.get(decode.charAt(j)));
            }
            codelists.add(codelist);
            maps.add(temp);

            map.clear();

        }

        for(int i=0;i<codelists.size();i++) {
            for (int j = 0; j < codelists.get(i).size(); j++) {
                if(maps.get(i).size()==0){
                    System.out.println("No solution."); break;
                }
                for (int k = 0; k < codelists.get(i).get(j).length(); k++) {
                    decode2.append(maps.get(i).get(codelists.get(i).get(j).charAt(k)));
                }
                System.out.println(decode2);
                decode2 = decode2.replace(0, decode2.length(), "");
            }
            if(i!=codelists.size()-1) System.out.println();
        }


	}
}