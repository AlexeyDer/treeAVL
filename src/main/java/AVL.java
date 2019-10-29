public class AVL extends Tree {

    public Vertex root;

    public int height(Vertex p) {
        return (p == null) ? 0 : p.getHeight();
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public Vertex LR(Vertex y) {
        Vertex x = y.getLeft();
        Vertex T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    public Vertex RL(Vertex x) {
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

    public Vertex insert(Vertex p, int data) {
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

        return p;
    }

    public Vertex minValueNode(Vertex vertex) {
        Vertex p = vertex;

        while (p.getLeft() != null)
            p = p.getLeft();
        return p;
    }

    public Vertex delete(Vertex root, int data) {
        if (root == null)
            return root;

        if (data < root.getData())
            root.setLeft(delete(root.getLeft(), data));
        else if (data > root.getData())
            root.setRight(delete(root.getRight(), data));
        else {
            if ((root.getLeft() == null || (root.getRight() == null))) {
                Vertex temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Vertex temp = minValueNode(root.getRight());
                root.setData(temp.getData());
                root.setRight(delete(root.getRight(), temp.getData()));
            }
        }

        if (root == null)
            return root;

        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);

        int balance = getBalance(root);

        // LL
        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return LR(root);

        // LR
        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            root.setLeft(RL(root.getLeft()));
            return LR(root);
        }

        // RR
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return RL(root);

        // RL
        if (balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(LR(root.getRight()));
            return RL(root);
        }

        return root;
    }

}
