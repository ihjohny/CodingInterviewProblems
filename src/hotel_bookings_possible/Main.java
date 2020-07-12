package hotel_bookings_possible;

import static java.util.Arrays.sort;

/**
 * Created by Imam Hossain on 7/12/20.
 * ihjony23@gmail.com
 */
//hotel_bookings_possible
public class Main {
    public static void main(String[] args) {
        int[] arrivals = {1, 3, 5};
        int[] departures = {2, 6, 8};
        int k = 1;
        System.out.println(isBookingsPossible(arrivals, departures, k));
    }

/*    //time complexity O(n*m) space complexity O(p)
    private static boolean isBookingsPossible(int[] arrivals, int[] departures, int k) {
        int size = arrivals.length;
        int[] days = new int[100000];
        for (int i = 0; i < size; i++) {
            for (int j = arrivals[i]; j < departures[i]; j++) {
                days[j]++;
                if(days[j] > k) {
                    return false;
                }
            }
        }
        return true;
    }*/

    //time complexity O(n log n)
    private static boolean isBookingsPossible(int[] arrivals, int[] departures, int k) {
        int size = arrivals.length;
        sort(arrivals);
        sort(departures);
        int i = 0, j = 0, count = 0;
        while (i < size && j < size) {
            if (arrivals[i] < departures[j]) {
                count++;
                i++;
                if (count > k) {
                    return false;
                }
            } else {
                count--;
                j++;
            }
        }

        return true;
    }
}
