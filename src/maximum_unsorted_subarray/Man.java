package maximum_unsorted_subarray;

import kotlin.Pair;

/**
 * Created by Imam Hossain on 7/13/20.
 * ihjony23@gmail.com
 */
//maximum_unsorted_subarray
public class Man {
    public static void main(String[] args) {
        //int[] array = {4, 5, 7, 9, 1, 3, 8, 20, 18};
        //int[] array = {4, 5, 7, 9, 1, 3, 8, 10, 18};
        int[] array = {4, 5, 7, 9, 1, 3, 8, 20, 18, 22, 23};
        System.out.println(maximumUnsortedSubarray(array));
    }

    // time complexity O(n) space complexity O(1)
    private static Pair<Integer, Integer> maximumUnsortedSubarray(int[] data) {
        int first = -1;
        int second = -1;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                first = i;
                break;
            }
        }

        for (int i = data.length - 1; i > 0; i--) {
            if (data[i] < data[i - 1]) {
                second = i;
                break;
            }
        }

        int min = data[first];
        int max = data[first];

        for(int i = first; i <= second; i++) {
            if(data[i] < min) {
                min = data[i];
            }
            if(data[i] > max) {
                max = data[i];
            }
        }

        for(int i = 0; i < first; i++) {
            if(data[i] > min) {
                first = i;
                break;
            }
        }

        for(int i = data.length - 1; i > second; i--) {
            if(data[i] < max) {
                second = i;
                break;
            }
        }

        return new Pair<>(first, second);
    }

/*    // time complexity O(n log n) space complexity O(n)
    private static Pair<Integer, Integer> maximumUnsortedSubarray(int[] data) {
        int[] temp = data.clone();
        sort(temp);
        int first = -1;
        int second = -1;
        for (int i = 0; i < data.length; i++) {
            if (temp[i] != data[i]) {
                if(first == -1) {
                    first = i;
                }
                second = i;
            }
        }
        return new Pair<>(first, second);
    }*/
}
