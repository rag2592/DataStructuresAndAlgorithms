import java.util.HashMap;

/**
 * Created by rsr37 on 7/7/2017.
 */
public class Question1_4 {
    public static boolean isPermutationOfPalindrome(String s)
    {
        char[] cArray = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: cArray)
        {   if(c != ' ') {
            if (map.containsKey(c)) {
                int temp = map.get(c);
                map.put(c, ++temp);
                }
            else
                map.put(c, 1);
            }
        }
        int eCount =0, oCount = 0;
        for(char a: map.keySet())
        {
            if(map.get(a)%2 == 0)
                eCount++;
            else
                oCount++;
        }
        return (oCount<=1);
    }


    public static void main(String[] args) {
        String pali = "taco cat";
        System.out.println(isPermutationOfPalindrome(pali));
        String pali2 = "llcbggiikk  ll";
        System.out.println(isPermutationOfPalindrome(pali2));
    }

}
