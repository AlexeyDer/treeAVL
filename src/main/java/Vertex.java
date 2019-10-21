
public class Vertex {
	private int data;
	private int height;
	private Vertex Right, Left;

	Vertex (int data){
		this.data = data;
		this.height = 1;
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
