package merge_overlapping_intervals;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.max;
import static java.util.Arrays.sort;

/**
 * Created by Imam Hossain on 7/19/20.
 * ihjony23@gmail.com
 */
//merge_overlapping_intervals
public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1, 10}, {2, 9}, {3, 8}, {4, 7}, {5, 6}, {6, 6}};
        System.out.println(mergeOverlappingIntervals(intervals).toString());
    }

    private static List<Pair> mergeOverlappingIntervals(int[][] intervals) {
        List results = new ArrayList<Pair>();
        sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int first = intervals[i][0];
            int second = intervals[i][1];
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] < second) {
                    second = max(intervals[j][1], second);
                    i++;
                } else {
                    break;
                }
            }
            results.add(new Pair(first, second));

        }
        return results;
    }
}