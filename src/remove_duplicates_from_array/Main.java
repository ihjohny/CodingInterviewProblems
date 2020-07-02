package remove_duplicates_from_array;

/**
 * Created by Imam Hossain on 7/2/20.
 * ihjony23@gmail.com
 */
//remove duplicates from array
public class Main{
    public static void main(String[] args){
        int[] numbers = new int[] {1,3,3,4,5,6,6,7,8,8};
        int unique = remove_duplicates(numbers);
        System.out.println("unique number: "+unique);
        for(int j = 0; j < unique; j++) {
            System.out.println(numbers[j]);
        }
    }

    public static int remove_duplicates(int[] nums) {
        int current_length = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[current_length] = nums[i];
                current_length++;
            }
        }
        return current_length;
    }
}