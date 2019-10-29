
public class Vertex {
    private int data;
    private int height;
    private Vertex Right, Left;
    private int Bal;

    Vertex(int data) {
        this.data = data;
        this.height = 1;
        this.Left = null;
        this.Right = null;
        this.Bal = 0;
    }

    public int getBal() {
        return Bal;
    }

    public void setBal(int bal) {
        Bal = bal;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Vertex getLeft() {
        return Left;
    }

    public Vertex getRight() {
        return Right;
    }

    public void setLeft(Vertex left) {
        Left = left;
    }

    public void setRight(Vertex right) {
        Right = right;
    }
}
