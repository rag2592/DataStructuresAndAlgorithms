import java.util.Arrays;

/**
 * Created by rsr37 on 7/7/2017.
 */
public class Question1_2 {
    public static String sort(String a)
    {
        char[] cArray =  a.toCharArray();
        Arrays.sort(cArray);
        return new String(cArray);
    }
    public static boolean permutation(String a, String b)
    {
        return sort(a).equals(sort(b));
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
