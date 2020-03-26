package algos;

import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n < 0 || trials < 0)
            throw new IllegalArgumentException("Illegal arguments");
    }

    // test client (see below)
    public static void main(String[] args) {

        int gridSize = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        Percolation percolation;
        double totalsum = 0;

        for (int i = 0; i < trials; i++) {
            percolation = new Percolation(gridSize);
            while (!percolation.percolates())
                percolation.open(StdRandom.uniform(gridSize), StdRandom.uniform(gridSize));
            int size = gridSize * gridSize;
            Double threshold = (double) percolation.numberOfOpenSites() / (double) size;
            totalsum += threshold;

        }
        System.out.println("Mean:                       " + totalsum / trials);
    }


}

