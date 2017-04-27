
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    private boolean [] grid;
    private int rowSize;
    private int gridSize;
    private int top = 0;
    private int bottom;
    private WeightedQuickUnionUF wqf;
    private int openSites = 0;
    
    public Percolation(int n) {
        if (n <= 0) {
            throw new java.lang.IllegalArgumentException("n is <= 0"); 
        }
        grid = new boolean[n * n];
        rowSize = n;
        gridSize = n * n;
        bottom = gridSize + 1;
        wqf = new WeightedQuickUnionUF(gridSize + 2);
    }
    
    private int toIndex(int row, int col) {
        row = row - 1;
        col = col - 1;
        return row * rowSize + col;
    }
    
    private boolean checkBounds(int idx) {
        if (idx > gridSize || idx < 0) {
            throw new java.lang.IndexOutOfBoundsException("Out of bounds.");
        }
        return true;
    }
    
    
    public void open(int row, int col) {
        int idx = toIndex(row, col);
        checkBounds(idx);
        grid[idx] = true; // set to open
        openSites++;
        // Update wqf
        
        if (row == 1) {
            wqf.union(toIndex(row, col), top);
        }
        
        if (row == bottom) {
            wqf.union(toIndex(row, col), bottom);
        }
        
        int adjRow = row - 1;
        int adjCol = col - 1;
        // Left
        int leftIdx = toIndex(row - 1, col);
        if (adjRow - 1 >= 0 && isOpen(row - 1, col)) {
            wqf.union(idx, leftIdx);
        }
        
        // Right
        int rightIdx = toIndex(row + 1, col);
        if (adjRow + 1 < rowSize && isOpen(row + 1, col)) {
            wqf.union(idx, rightIdx);
        }
        
        // Top
        int topIdx = toIndex(row, col + 1);
        if (adjCol + 1 < rowSize && isOpen(row, col + 1)) {
            wqf.union(idx, topIdx);
        }
        
        // Top
        int bottomIdx = toIndex(row, col - 1);
        if (adjCol - 1 >= 0 && isOpen(row, col - 1)) {
            wqf.union(idx, bottomIdx);
        }
    }
    
    public boolean isOpen(int row, int col) {
        int idx = toIndex(row, col);
        checkBounds(idx);
        return grid[idx];
    }
    
    public boolean isFull(int row, int col) {
        int idx = toIndex(row, col);
        checkBounds(idx);
        
        if (isOpen(row, col)) {
            // Check if connected to an open spot on the first row
            for (int i = 0; i < rowSize; i++) {
                if (wqf.connected(toIndex(row, col), i)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public int numberOfOpenSites() {
        return openSites;
    }
    
    public boolean percolates() {
        return wqf.connected(top, bottom);
    }
    
}


