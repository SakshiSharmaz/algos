package algos;

public class QuickFindUF {

    private int[] id;

    //initialization through constructor
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    void union(int p, int q) {

        if (!connected(p, q)) {
            int pid = id[p];
            int qid = id[q];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pid)
                    id[i] = qid;
            }

        }

    }
}
