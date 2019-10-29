public class BTree extends Tree {
    Vertex root;

    private int HR = 1;
    private int VR = 1;


    public Vertex insert(int D, Vertex p) {
        if (p == null) {
//            p = new Vertex(D);
            VR = 1;
            return new Vertex(D);
        } else {
            if (p.getData() > D) {
               p.setLeft(insert(D, p.getLeft()));
                if (VR == 1) {
                    if (p.getBal() == 0) {
                        Vertex q = p.getLeft();
                        p.setLeft(q.getRight());
                        q.setRight(p);
                        p = q;
                        q.setBal(1);

                        VR = 0;
                        HR = 1;
                    } else {
                        p.setBal(0);
                        VR = 1;
                        HR = 0;
                    }
                } else {
                    HR = 0;
                }
            } else {
                if (p.getData() < D) {
                    p.setRight(insert(D, p.getRight()));
                    if (VR == 1) {
                        p.setBal(1);
                        HR = 1;
                        VR = 0;
                    } else {
                        if (HR == 1) {
                            if (p.getBal() == 1) {
                                Vertex q = p.getRight();
                                p.setBal(0);
                                q.setBal(0);
                                p.setRight(q.getLeft());
                                q.setLeft(p);
                                p = q;

                                VR = 1;
                                HR = 0;
                            } else {
                                HR = 0;
                            }
                        }
                    }
                }
            }
        }
        return p;
    }


}
