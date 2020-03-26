package algos;

public class QuickUnionUF {

    private int[] id;

    //initialization through constructor
    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    int root(int n) {
        int i = n;
        while (id[i] != i)
            i = id[i];
        return i;
    }

    boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    void union(int p, int q) {
        if (!connected(p, q)) {
            int proot = root(p);
            int qroot = root(q);
            id[proot] = qroot;
        }
    }
}
