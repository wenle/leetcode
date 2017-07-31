package jianzhioffer;

/**
 * date 17/7/30
 *
 * @author wenle
 */
public class Question20 {

    public static void printMatrixClockwise(int[][] matrix, int length, int width) {

        System.out.println("Print start");
        printCircle(matrix, length, width, 0);
        System.out.println();

    }

    private static void printCircle(int[][] matrix, int length, int width, int x) {

        int bottomX = width - 1 - x;
        int rightY = length -1 - x;

        if(bottomX < x || rightY < x) {
            return;
        }
        for(int i = x; i<= rightY; i++) {

            System.out.print(matrix[x][i]);
            System.out.print(' ');
        }
        for(int i = x+1; i<= bottomX; i++) {
            System.out.print(matrix[i][rightY]);
            System.out.print(' ');
        }
        if(bottomX > x) {
            for (int i = rightY - 1; i >= x; i--) {
                System.out.print(matrix[bottomX][i]);
                System.out.print(' ');
            }
        }
        if(rightY > x) {
            for (int i = bottomX - 1; i > x; i--) {
                System.out.print(matrix[i][x]);
                System.out.print(' ');
            }
        }

        printCircle(matrix, length, width, x+1);
    }

    public static void main(String[] args) {

        int[][] emptyMatrix = new int[][]{};
        printMatrixClockwise(emptyMatrix, 0, 0);

        int[][] oneLine = new int[][]{{1, 2, 3}};
        printMatrixClockwise(oneLine, 3, 1);

        int[][] oneColumn = new int[][]{{1},{2}, {3}};
        printMatrixClockwise(oneColumn, 1, 3);


        int[][] matrix = new int[][]{{1, 2, 3, 4},{5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixClockwise(matrix, 4, 3);

    }

}
