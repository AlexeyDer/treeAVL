public class AVL extends Tree {

    public Vertex root;

    public int height(Vertex p) {
        return (p == null) ? 0 : p.getHeight();
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public Vertex LR (Vertex y) {
        Vertex x = y.getLeft();
        Vertex T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    public Vertex RL (Vertex x) {
        Vertex y = x.getRight();
        Vertex T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    public int getBalance(Vertex p) {
        if (p == null)
            return 0;
        return height(p.getLeft()) - height(p.getRight());
    }

    public Vertex insert (Vertex p, int data) {
        if (p == null)
            return (new Vertex(data));

        if (data < p.getData())
            p.setLeft(insert(p.getLeft(), data));
        else if (data > p.getData())
            p.setRight(insert(p.getRight(), data));
        else
            return p;

        p.setHeight(1 + max(height(p.getLeft()), height(p.getRight())));

        int balance = getBalance(p);

        // LL
        if (balance > 1 && data < p.getLeft().getData()) {
            return LR(p);
        }

        // RR
        if (balance < -1 && data > p.getRight().getData())
            return RL(p);

        // LR
        if (balance > 1 && data > p.getLeft().getData()) {
            p.setLeft(RL(p.getLeft()));
            return LR(p);
        }

        // RL
        if (balance < -1 && data < p.getRight().getData()) {
            p.setRight(LR(p.getRight()));
            return RL(p);
        }

        return  p;
    }

}
