package merge_intervals;


import java.util.ArrayList;
import java.util.List;

import kotlin.Pair;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by Imam Hossain on 7/20/20.
 * ihjony23@gmail.com
 */
//merge_intervals
public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}, {6, 9}, {12, 18}, {22, 23}, {24, 30}, {36, 66}};
        System.out.println(merge_intervals(intervals, 6, 24).toString());
    }

    private static List<Pair> merge_intervals(int[][] intervals, int first, int second) {
        List results = new ArrayList<Pair>();
        int start = 0, end = 0;
        int len = intervals.length;

        while (end < len) {
            if (first <= intervals[end][1]) {
                if (second < intervals[end][0]) {
                    break;
                }
                first = min(first, intervals[end][0]);
                second = max(second, intervals[end][1]);
            } else {
                start++;
            }
            end ++;
        }
        for (int i = 0; i < start; i++) {
            results.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        results.add(new Pair(first, second));
        for (int i = end; i < len; i++) {
            results.add(new Pair(intervals[i][0], intervals[i][1]));
        }

        return results;
    }
}
