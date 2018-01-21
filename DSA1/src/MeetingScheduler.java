/**
 * Created by rsr37 on 1/9/2018.
 */
import java.util.*;

class Interval{
    int start;
    int end;
    Interval(int s, int e){
        start = s;
        end = e;
    }
}
public class MeetingScheduler {
    public static int meetingScheduler(Interval[] intervals) {
        int nRooms = 0;
        int count = intervals.length;
        int[] stimes = new int[count];
        int[] etimes = new int[count];
        for(int i =0;i < count ;i++){
            stimes[i] = intervals[i].start;
            etimes[i] = intervals[i].end;
        }
        // sorting the start and end times
        // This way we can have a keep incrementing the rooms as long as there is a meeting running
        Arrays.sort(stimes);
        Arrays.sort(etimes);
        int j =0; // to iterate  the etimes
        for(int i =0; i < count; i++){
            if(stimes[i] < etimes[j])
                nRooms++;
            else
                j++;
        }
        return nRooms;
    }
    public static void main(String[] args){
        Interval[] array = new Interval[4];
        array[0] = new Interval(1,3);
        array[1] = new Interval(5,7);
        array[2] = new Interval(2,4);
        array[3] = new Interval(3,6);
        System.out.println("The min number of rooms required is:"+meetingScheduler(array));
    }
}
