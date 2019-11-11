class Tree {
    Vertex root;


    public int Depth(Vertex p, int dep_count) {
        return (p == null) ? dep_count : Math.max(Depth(p.getLeft(), dep_count + 1), Depth(p.getRight(), dep_count + 1));
    }

    public Vertex CreateISPD(int l, int r, int[] a) {
        if (l > r)
            return null;
        else {
            int m = (l + r) / 2;
            Vertex p = new Vertex(a[m]);
            p.setLeft(CreateISPD(l, m - 1, a));
            p.setRight(CreateISPD(m + 1, r, a));
            return p;
        }
    }

    public Vertex Search(Vertex p, int key) {
        while (p != null) {
            if (key < p.getData())
                p = p.getLeft();
            else if (key > p.getData())
                p = p.getRight();
            else
                break;
        }
        if (p != null)
            return p;
        else
            return null;
    }

    public static void Obhod1(Vertex p) {
        if (p != null) {
            Obhod1(p.getLeft());
            System.out.print(p.getData() + " ");
            Obhod1(p.getRight());
        }

    }

    public int Size(Vertex p) {
        if (p == null)
            return 0;
        else
            return 1 + Size(p.getLeft()) + Size(p.getRight());

    }

    public int Sum(Vertex p) {
        if (p == null)
            return 0;
        else
            return p.getData() + Sum(p.getLeft()) + Sum(p.getRight());
    }

    public int Sumlength(Vertex p, int l) {
        if (p == null)
            return 0;
        else
            return l + Sumlength(p.getLeft(), l + 1) + Sumlength(p.getRight(), l + 1);
    }

    public int Height(Vertex p) {
        if (p == null)
            return 0;
        else
            return 1 + Math.max(Height(p.getLeft()), Height(p.getRight()));
    }

}
