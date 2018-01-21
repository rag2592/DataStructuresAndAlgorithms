/**
 * Created by rsr37 on 7/8/2017.
 */
public class Question1_6 {
    public static String compress(String a)
    {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i = 0; i< a.length(); i++)
        {
            countConsecutive++;
            if(i+1 >= a.length() || a.charAt(i) != a.charAt(i+1)){
                compressed.append(a.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        String b = compressed.toString();
        if(a.length() == b.length())
            return a;
        else
            return compressed.toString();
    }

    public static void main(String[] args) {
        String str = "aacccbb";
        System.out.println(str);
        System.out.println(compress(str));
    }
}
