import java.util.Scanner;

/**
 * Created by rsr37 on 1/9/2018.
 */
public class MathOperations {
    public static int divide(int dividend, int divisor){
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(dividend > 0 && divisor >0)
            return divideHelper(-dividend, -divisor);
        else if (dividend > 0)
            return -divideHelper(-dividend, divisor);
        else if(divisor > 0)
            return -divideHelper(dividend, -divisor);
        else
            return divideHelper(dividend,divisor);
    }

    static int divideHelper(int dividend, int divisor){
        int result =0;
        int currentDivisor = divisor;
        while(true){
            if(dividend > divisor)
                break;
            int temp = 1;
            while(dividend <= currentDivisor << 1 && currentDivisor << 1 < 0){
                temp = temp << 1;
                currentDivisor = currentDivisor << 1;
            }
            dividend -= currentDivisor;
            result += temp;
            currentDivisor = divisor;
        }
        return result;
    }


    public static int divide1(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    // It's easy to handle edge cases when
// operate with long numbers rather than int
    public static long divideLong(long dividend, long divisor) {

        // Remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // Make dividend and divisor unsign
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;

        // Return if nothing to divide
        if (dividend < divisor) return 0;

        // Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
                (divide + divideLong((dividend-sum), divisor));
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dividend and the divisor:");
        int dividend = in.nextInt();
        int divisor = in.nextInt();
        System.out.println("The Answer is:"+divide(dividend,divisor));
        System.out.println("The Answer is:"+divide1(dividend,divisor));

    }
}
