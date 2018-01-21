/**
 * Created by rsr37 on 7/8/2017.
 */
public class Question1_7 {
    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Before Rotation"+ "\n");
        for(int i =0; i < matrix.length;i++)
        {
            for(int j =0;j< matrix[0].length;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        rotate(matrix);
        System.out.println("After" + "\n");

        for(int i =0; i < matrix.length;i++)
        {
            for(int j =0;j< matrix[0].length;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
