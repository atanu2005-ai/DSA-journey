package Array.problems;

public class SetMatrixZero {
    //Questin: A m*n matrix is given of only 0s and 1s. If an element is 0 set the entire roq and column to 0s.
    //Key point: We have to consider only initial 0s in the matrix, not those which are being changed ot 0s.

    //Brute force
    public static void bruteForce(int[][] matrix, int n, int m) {
        //to prevent considering new 0s we assign the target elements as -1 instead of 0
        //then we iterate again and change those -1s to 0
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    for(int col = 0; col < m; col++) matrix[i][col] = -1;
                    for(int row = 0; row < n; row++) matrix[row][j] = -1;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    //Better
    public static void better(int[][] matrix, int n, int m) {
        //We will create two indicator arrays which will show if that row or column is supposed to be
        //affected or not
        /*            col
                   -------------
                   -------------
        *       | | 1  1  1  1
        *   row | | 1  0  1  1
        *       | | 1  1  0  1
        * */

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    //Optimal
    public static void optimal(int[][] matrix, int n, int m) {
        //instead of taking extra space for indicator arrays we assume the first row and the first column
        //itself as the indicator arrays
        //notice for index 0,0, they will overlap and return unexpected answer due to collision.
        //so we take the row indicator as it should be and take col indicator except the 1st index and
        //assume it is there hypothetically but not the exact 1st index, let me visualize:
        /**
         *    ____   <- this part
         *    ---- ___________
         *    |  | ___________ col indicator
         * row|  |
         *    |  |
         */

        //we divide the process into 3 stages:
        //stage 1:
        //create the indicators
        int col0 = 1; //
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    if(j != 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }else {  //if it's 1st col then as a col indicator we have to assign to the hypothetical position
                        col0 = 0;
                    }
                }
            }
        }

        //stage 2:
        //using the indicator arrays, change the values as required
        for(int i = 1; i < n; i++) { //notice we are iterating leaving the first row and col as they are the indicators
            for(int j = 1; j < m; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //stage 3:
        //now time to fix the indicator arrays itself
        //iterating the 1st col first will create wrong answer as it will affect the 1st row
        //we are going to iterate later so let's first work on the 1st row. [please watch striver's video why it creates problem]
        for(int i = 1; i < m; i++) {
            if(matrix[0][0] == 0) {
                matrix[0][i] = 0;
            }
        }
        for(int i = 0; i < n; i++) {
            if(col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}};
        int n1 = grid1.length;
        int m1 = grid1[0].length;
        bruteForce(grid1, n1, m1);
        System.out.println("Brute force:");
        for (int[] ints : grid1) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int[][] grid2 = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}};
        int n2 = grid2.length;
        int m2 = grid2[0].length;
        bruteForce(grid2, n2, m2);
        System.out.println("Better:");
        for (int[] ints : grid2) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int[][] grid3 = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}};
        int n3 = grid3.length;
        int m3 = grid3[0].length;
        bruteForce(grid3, n3, m3);
        System.out.println("Optimal:");
        for (int[] ints : grid3) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
