import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author grozhd
 */
public class P3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s = "";
        while (s.length() == 0) {
            s = sc.nextLine();
        }
        char[] pokemons = s.toCharArray();

        Set<Character> pokemonTypes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            pokemonTypes.add(pokemons[i]);
        }

        int types = pokemonTypes.size();

        int l = 0;
        int r = 0;
        int min = n;
        Map<Character, Integer> currentPokemons = new HashMap<>();


        while (r < n) {
            while (currentPokemons.size() < types && r < n) {
                char pokemon = pokemons[r++];
                currentPokemons.merge(pokemon, 1, (a, b) -> a + b);
            }
            min = Math.min(r - l, min);

            while (currentPokemons.size() == types) {
                char pokemon = pokemons[l++];
                if (currentPokemons.get(pokemon) == 1) {
                    currentPokemons.remove(pokemon);
                } else {
                    min = Math.min(r - l, min);
                    currentPokemons.put(pokemon, currentPokemons.get(pokemon) - 1);
                }
            }
        }

        min = Math.min(min, r - l + 1);
        min = Math.max(min, types);

        System.out.println(min);

    }
}