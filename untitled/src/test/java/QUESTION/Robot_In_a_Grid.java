import java.util.ArrayList;

    class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    class Solution {
            public ArrayList<Point> findPath(boolean[][] grid) {
                if (grid == null || grid.length == 0)
                    return null;

                ArrayList<Point> path = new ArrayList<Point>();
                if (findPath(grid, grid.length - 1, grid[0].length - 1, path))
                    return path;

                else return null;
            }

            private boolean findPath(boolean[][] grid, int row, int col, ArrayList<Point> path) {
                if (!isInRange(grid, row, col) || grid[row][col]) return false;
                if ((row == 0 && col == 0) || findPath(grid, row, col - 1, path) || findPath(grid, row - 1, col, path)) {
                    Point p = new Point(row, col);
                    path.add(p);
                    return true;
                }
                return false;
            }

            private boolean isInRange(boolean[][] grid, int row, int col) {
                return row >= 0 && row <= grid.length - 1
                        && col >= 0 && col <= grid.length - 1;
            }
    }

public class Robot_In_a_Grid {
    public static void main(String[] args) {
        boolean[][] grid = {
                {false, false, false, false},
                {false, false, false, true},
                {true, true, false, false},
                {false, false, false, false}
        };
        Solution sol = new Solution();
        ArrayList<Point> path = sol.findPath(grid);
        System.out.println("=======================================");
        if (path != null) {
            for (Point p : path)
                System.out.print(p.row + "" + p.col + "->");
        }
        System.out.println();
        System.out.println("=======================================");
    }
}

