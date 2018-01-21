import java.util.Scanner;

/**
 * Created by rsr37 on 1/9/2018.
 */
public class OneCountBinary {
    static int countOnes(int n){
        int c = 0;
        while(n > 0){
            if(n%2 == 1)
                c++;
            n = n/2;

        }
        return c;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = in.nextInt();
        System.out.println("The number of One's in its binary conversion is: "+ countOnes(n));
    }
}
