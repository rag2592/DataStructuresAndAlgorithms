import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by rsr37 on 1/9/2018.
 */
public class Reverse {
    public static void main(String[] args){
        String sentence;
        System.out.println("Enter the sentence");
        Scanner in = new Scanner(System.in);
        sentence = in.next();
        //Pattern pattern = Pattern.compile("\\S");

        // splitting String str with a pattern
        // (i.e )splitting the string whenever their
        //  is whitespace and store in temp array.
        String[] temp = sentence.trim().split("\\\\s+");
        String result = "";

        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = temp.length - 1; i > 0; i--) {
            result += temp[i] + " ";
        }
        result += temp[0];
        System.out.println(result);
    }
}
