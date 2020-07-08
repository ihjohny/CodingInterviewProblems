package maximum_sum_contiguous_subarray;

/**
 * Created by Imam Hossain on 7/8/20.
 * ihjony23@gmail.com
 */
//Maximum Sum Contiguous Subarray
public class Main {
    public static void main(String[] args) {
        int[] array = {-1, -2, 1, 2, 3, -5, 4, 5};
        System.out.println(maximumSumContiguous(array));
    }

    //complexity n
    private static int maximumSumContiguous(int[] data){
        int size = data.length;
        int maxSum = -9999999; //a large negative number
        int currentSum = 0;
        for (int i = 0; i < size; i++) {
            currentSum += data[i];
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    //complexity n^2
    /*private static int maximumSumContiguous(int[] data){
        int size = data.length;
        int maxSum = data[0];
        for(int i = 0; i < size; i++) {
            if(data[i] > maxSum) {
                maxSum = data[i];
            }
            int sum = data[i];
            for (int j = i+1; j < size; j++) {
                sum += data[j];
                if(sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }*/
    
}