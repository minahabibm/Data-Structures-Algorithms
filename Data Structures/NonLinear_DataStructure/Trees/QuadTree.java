public class QuadTree {
    private QuadNode root;

    public QuadTree(int[][] grid) {
        this.root = construct(grid, 0, 0, grid.length);
    }
    
    // Bottom-Up Merge
    /** 
    private QuadNode construct(int[][] grid, int x, int y, int size) {
        if (size == 1)
            return new QuadNode(grid[x][y] == 1, true);

        int half = size / 2;
        QuadNode topLeft  = construct(grid, x, y, half);
        QuadNode topRight = construct(grid, x, y + half, half);
        QuadNode bottomLeft  = construct(grid, x + half, y, half);
        QuadNode bottomRight = construct(grid, x + half, y + half, half);
        
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val)
            return new QuadNode(topLeft.val, true);
        else
            return new QuadNode(false, false, topLeft, topRight, bottomLeft, bottomRight);
    } 
    */
   
    // Top-Down Uniform Check
    private QuadNode construct(int[][] grid, int row, int col, int size) {
        if (isUniform(grid, row, col, size))
            return new QuadNode(grid[row][col] == 1, true);
        
        int half = size / 2;
        QuadNode topLeft  = construct(grid, row, col, half);
        QuadNode topRight = construct(grid, row, col + half, half);
        QuadNode bottomLeft  = construct(grid, row + half, col, half);
        QuadNode bottomRight = construct(grid, row + half, col + half, half);

        return new QuadNode(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) return false;
            }
        }
        return true;
    }

    // Printing the QuadTree
    private void printTree() {
        printTree(this.root, 0);
    }
    private void printTree(QuadNode node, int level) {
        if (node == null) return;

        // Indent according to level
        String indent = " ".repeat(level * 2);

        if (node.isLeaf) {
            System.out.println(indent + "Leaf: " + (node.val ? "1" : "0"));
        } else {
            System.out.println(indent + "Node:");
            System.out.println(indent + " topLeft:");
            printTree(node.topLeft, level + 1);

            System.out.println(indent + " topRight:");
            printTree(node.topRight, level + 1);

            System.out.println(indent + " bottomLeft:");
            printTree(node.bottomLeft, level + 1);

            System.out.println(indent + " bottomRight:");
            printTree(node.bottomRight, level + 1);
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 0, 0},
            {1, 1, 0, 0}
        };

        QuadTree quadTree = new QuadTree(grid);
        System.out.println("QuadTree constructed successfully.");

        // Print the QuadTree
        quadTree.printTree();
    }

}

class QuadNode {
    public boolean val;
    public boolean isLeaf;
    public QuadNode topLeft;
    public QuadNode topRight;
    public QuadNode bottomLeft;
    public QuadNode bottomRight;

    
    public QuadNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public QuadNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public QuadNode(boolean val, boolean isLeaf, QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}