//package QUESTION;
//
//public class Rotation {
//
//    public static void main(String args[]) {
//
//        int row = 6;
//        int columns = 6;
//        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
//        solution(row, columns, queries);
//    }
//
//    static int[][] matrix;
//
//    public static int[] solution(int rows, int columns, int[][] queries) {
//        int[] answer = new int[queries.length];
//        ;
//        matrix = new int[rows][columns];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                matrix[i][j] = i * columns + j + 1;
//            }
//        }
//
//        for (int i = 0; i < queries.length; i++) {
//            answer[i] = rotate(queries[i]);
//        }
//
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        return answer;
//    }
//
//    private static void rotate(int[] query) {
//        int r1 = query[0] - 1;
//        int c1 = query[1] - 1;
//        int r2 = query[2] - 1;
//        int c2 = query[3] - 1;
//
//        int temp = matrix[r1][c1];
//        int min = temp;
//
//        for (int i = r1; i < r2; i++) { // 회전의 1번
//            matrix[i][c1] = matrix[i + 1][c1];
//            if (min > matrix[i][c1]) min = matrix[i][c1];
//        }
//
//        for (int i = c1; i < c2; i++) { // 회전의 2번
//            matrix[r2][i] = matrix[r2][i + 1];
//            if (min > matrix[r2][i]) min = matrix[r2][i];
//        }
//        for (int i = r2; i > r1; i--) { // 회전의 3번
//            matrix[i][c2] = matrix[i - 1][c2];
//            if (min > matrix[i][c2]) min = matrix[i][c2];
//        }
//        for (int i = c2; i > c1; i--) { // 회전의 4번
//            matrix[r1][i] = matrix[r1][i - 1];
//            if (min > matrix[r1][i]) min = matrix[r1][i];
//        }
//        matrix[r1][c1 + 1] = temp; // 임시저장한 값 저장
//        return min;
//    }
//}
