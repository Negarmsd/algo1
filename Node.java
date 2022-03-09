public class Node{
	private int value;
	public int height;
	protected Node left;
	protected Node right;
	protected Node parent;

	public Node(int value) {
		this.value = value;
		
		left = null;
		right = null;
		parent = null;
	}
	public void h(int h) {
		height = h;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getHeight() {
		return height;
	}
	public int getValue() {
		return value;
	}
}
