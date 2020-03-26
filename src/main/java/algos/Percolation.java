package algos;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[][] grid;
    private int openSites;
    private WeightedQuickUnionUF unionUF;
    private int size;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        size = n;
        unionUF = new WeightedQuickUnionUF(n * n + 2);

        for (int i = 1; i <= n; i++) {
            unionUF.union(0, i);
            unionUF.union(n * n + 1, n * n - i);
        }
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int currentIndex = col + (row) * size + 1;
        if (row < 0 || col < 0)
            throw new IllegalArgumentException("Invalid row or col value");
        if (grid[row][col] == 1) return;
        grid[row][col] = 1;
        openSites++;
        if (row - 1 >= 0 && grid[row - 1][col] == 1)
            unionUF.union(currentIndex, col + (row - 1) * size + 1);
        if (col - 1 >= 0 && grid[row][col - 1] == 1)
            unionUF.union(currentIndex, (col - 1) + (row) * size + 1);
        if (col + 1 < size && grid[row][col + 1] == 1)
            unionUF.union(currentIndex, (col + 1) + (row) * size + 1);
        if (row + 1 < size && grid[row + 1][col] == 1)
            unionUF.union(currentIndex, col + (row + 1) * size + 1);

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0)
            throw new IllegalArgumentException("Invalid row or col value");
        return grid[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || col < 0)
            throw new IllegalArgumentException("Invalid row or col value");
        return unionUF.find(0) == unionUF.find(grid.length * grid.length + 1);

    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return unionUF.find(0) == unionUF.find((size) * (size) + 1);
    }


}
