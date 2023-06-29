import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    static class Data implements Comparable<Data> {
        int weight;
        int strength;
        public Data(int weight, int strength) {
            this.weight = weight;
            this.strength = strength;
        }

        public int compareTo(Data d) {
            return (strength != d.strength)? strength - d.strength : weight - d.weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Data d = new Data(0, 0);
        ArrayList<Data> list = new ArrayList<>();
        while(input != null && input.length() != 0) {
            d.weight = Integer.parseInt(input.split(" ")[0]);
            d.strength = Integer.parseInt(input.split(" ")[1]);
            list.add(d);
            d = new Data(0, 0);
            input = br.readLine();
        }
        Collections.sort(list);
        ArrayList<Integer> D = new ArrayList<>();
        int maxi;
        for(int i = 1; i <= list.size(); i++)
            D.add(Integer.MAX_VALUE);
        D.set(0, 0);
        maxi = 0;

        for(int i = 0; i < list.size(); i++) {
            for(int j = maxi; j >= 0; j--) {
                if(D.get(j) + list.get(i).weight < list.get(i).strength && D.get(j) + list.get(i).weight < D.get(j + 1) && D.get(j) != Integer.MAX_VALUE) {
                    D.set(j + 1, D.get(j) + list.get(i).weight);
                    maxi = Math.max(maxi, j + 1);
                }
            }
        }
        System.out.println(maxi);
    }
}