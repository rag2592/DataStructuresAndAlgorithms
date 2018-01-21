import java.util.Random;

/**
 * Created by rsr37 on 7/12/2017.
 */
public class MissingNumber {

    public static int findMissing(int[] boxes)
    {
        int sum = (100*101)/2;
        for(int i:boxes)
            sum -= i;
        return sum;
    }
    public static void main(String[] args)
    {

    }
}
