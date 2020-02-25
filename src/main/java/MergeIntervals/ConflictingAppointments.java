package MergeIntervals;

import java.util.*;

public class ConflictingAppointments {


    public static boolean canAttendAllAppointments(Interval[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a.start));
        if (arr.length == 1)
            return true;
        boolean result = true;
        for(int i =1; i < arr.length; i++) {
            Interval previousInterval = arr[i-1];
            Interval currentInterval = arr[i];

            if((previousInterval.start>= currentInterval.start && previousInterval.start <= currentInterval.end) ||
                    (currentInterval.start >= previousInterval.start && currentInterval.start <= previousInterval.end)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
