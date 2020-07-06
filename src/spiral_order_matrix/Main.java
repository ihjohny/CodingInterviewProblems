package spiral_order_matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Imam Hossain on 7/2/20.
 * ihjony23@gmail.com
 */
//matrix representation in spiral order
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matrixRow, matrixColumn;
        int[][] matrix = new int[100][100];

        System.out.println("Enter Matrix Row...");
        matrixRow = input.nextInt();

        System.out.println("Enter Matrix Column...");
        matrixColumn = input.nextInt();

        System.out.println("Enter Matrix Data...");
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixColumn; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        System.out.println("Spiral Order of the Matrix...");

        System.out.println(spiralOrderMatrix(matrix, matrixRow, matrixColumn));
    }

    private static List<Integer> spiralOrderMatrix(int[][] matrix, int row, int column) {
        ArrayList<Integer> result = new ArrayList<>();

        if (row == 0) {
            return result;
        }
        int direction = 0;
        int left = 0, right = column-1, top = 0, bottom = row-1;

        do {
            if (direction == 0) {
                for (int i = left; i < right+1; i++)
                    result.add(matrix[top][i]);
                top++;
            } else if (direction == 1) {
                for (int i = top; i < bottom+1; i++)
                    result.add(matrix[i][right]);
                right--;
            } else if (direction == 2) {
                for (int i = right; i > left-1; i--)
                    result.add(matrix[bottom][i]);
                bottom--;
            } else {
                for (int i = bottom; i > top-1; i--)
                    result.add(matrix[i][left]);
                left++;
            }

            direction = (direction + 1) % 4;

        } while (left != column-1 || right != 0 || top != row-1 || bottom != 0);

        return result;
    }
}
