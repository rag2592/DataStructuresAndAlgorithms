import java.util.HashMap;

/**
 * Created by rsr37 on 7/7/2017.
 */
public class Question1_1 {
    public static boolean isUniqueChars(String word)
    {
        char[] cArray = word.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: cArray)
        {
            if(map.containsKey(c))
                return false;
            else {
                map.put(c,1);
                }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}