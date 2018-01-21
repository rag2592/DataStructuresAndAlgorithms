import java.util.HashSet;

/**
 * Created by rsr37 on 1/10/2018.
 */
public class longestConseqSub {

    static int lengthSub(int arr[]){
        int length = arr.length;
        HashSet<Integer> set = new HashSet<Integer>();
        int result = 0;
        // put all the elements on to the hash set
        for(int i = 0; i < length; i++)
            set.add(arr[i]);
        for(int i =0 ;i < length;i++) {
            // checking from the start, considering the element on the array as the start of the subsequence
            if (!set.contains(arr[i] - 1)){

                int next = arr[i];
                while(set.contains(next))
                    next++;

                if(next - arr[i] > result)
                    result = next - arr[i];
            }

        }
        return result;
    }
    public static void main(String[] args){
        int arr[] = {1,9,3,10,4,20,2};
        System.out.println("The length of the longest incremental subsequence is:"+lengthSub(arr));
    }
}
