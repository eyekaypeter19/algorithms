package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            Interval first = arr1[i];
            Interval second = arr2[j];
            if ((first.start >= second.start && first.start <= second.end) ||
            second.start>= first.start && second.start <= first.end) {
                int start = Math.max(first.start, second.start);
                int end = Math.min(second.end, first.end);
                intervalsIntersection.add(new Interval(start, end));
            }
            //move from the interval that is finishing first
            if(first.end < second.end) {
                i++;
            }
            else {
                j++;
            }
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}