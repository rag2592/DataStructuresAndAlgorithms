/**
 * Created by rsr37 on 7/8/2017.
 */
public class Question1_8 {
    public static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        // Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        for (int k = 0; k < m1.length; k++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[k][j] != m2[k][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] c = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                c[i][j] = matrix[i][j];
            }
        }
        return c;
    }

    public static void main(String[] args) {

        int[][] matrix = {{4,5,0,1},{6,7,1,0},{1,4,1,1},{5,4,3,1},{4,7,2,1}};

        System.out.println("Before"+ "\n");
        for(int i =0; i < matrix.length;i++)
        {
            for(int j =0;j< matrix[0].length;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        setZeros(matrix);

        System.out.println();

        System.out.println("After" + "\n");

        for(int i =0; i < matrix.length;i++)
        {
            for(int j =0;j< matrix[0].length;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
