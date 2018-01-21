import java.util.Scanner;

/**
 * Created by rsr37 on 7/7/2017.
 */
public class Question1_3 {
    public static String convertString(String str) {
        String[] words = str.split("\\s+");
        StringBuilder sentence = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; ++i) {
            sentence.append("%20");
            sentence.append(words[i]);
        }

        return sentence.toString();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String result = convertString(input);
        System.out.println(result);
    }
}
