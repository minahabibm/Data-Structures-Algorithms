public class Grid {

    // Traverse 8 directions neightbor directions
    private static final int[][] DIRECTIONS = new int[][] {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0},                                       // Up, Down, Left, Right
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}                                      // Diagonal directions
    };
    public void traverseNeighbors(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Traverse 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Current cell: (" + i + ", " + j + ") = " + grid[i][j]);

                for (int[] dir : DIRECTIONS) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    // Check if the new cell is within the bounds of the grid
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        System.out.println("Neighbor cell: (" + newRow + ", " + newCol + ") = " + grid[newRow][newCol]);
                    }
                }

            }
        }
        
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        new Grid().traverseNeighbors(grid);
    }

}