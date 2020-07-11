package max_distance;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.Comparator;

import static java.lang.Math.max;

/**
 * Created by Imam Hossain on 7/11/20.
 * ihjony23@gmail.com
 */
//max_distance
public class Main {
    public static void main(String[] args) {
        int[] array = {13, 5, 4, 2, 8};
        System.out.println(maxDistance(array));
    }

    //complexity O(n log n)
    private static int maxDistance(int[] array) {
        ArrayList<Pair<Integer, Integer>> temp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            temp.add(new Pair(array[i], i));
        }
        temp.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> integerIntegerPair, Pair<Integer, Integer> t1) {
                return (integerIntegerPair.component1() - t1.component1());
            }
        });
        int low = temp.get(0).component2();
        int result = 0;
        for (Pair<Integer, Integer> integerIntegerPair : temp) {
            if (integerIntegerPair.component2() <= low) {
                low = integerIntegerPair.component2();
            } else {
                result = max(result, (integerIntegerPair.component2() - low));
            }
        }
        return result;
    }
}
