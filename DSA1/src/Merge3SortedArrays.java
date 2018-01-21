import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rsr37 on 1/9/2018.
 */
public class Merge3SortedArrays {
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(4);
        a.add(7);
        a.add(10);
        a.add(20);
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(5);
        b.add(9);
        b.add(17);
        b.add(25);
        ArrayList<Integer> ab = new ArrayList<Integer>();
        ab.addAll(a);
        ab.addAll(b);
        Collections.sort(ab);
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(5);
        c.add(9);
        c.add(17);
        c.add(25);
        ab.addAll(c);
        Collections.sort(ab);
        System.out.println(ab);

    }
}
