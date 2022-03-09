import java.util.*;
public class Tree {
	public Node root;
	private List<Integer> child = new ArrayList<Integer>();
	private Node current;
	public void makeTree(int[] numbers) {
		root = new Node(numbers[0]);
		current = root;
		for (int i = 1; i < numbers.length; i++) {
			addValue(root, numbers[i]);

		}
	
	}
	public Node min(Node x) {
		while (x.left != null) x = x.left;
		return x;
	}
	public Node max(Node x) {
		while (x.right != null) x = x.right;
		return x;
	}
	public Node search(Node x, int k) {
		while (x != null) {
			if (x.getValue() == k) return x;
			if (x.getValue() > k) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		
		return null;
	}
	public Node successor(int n) {
		Node x = search(root, n);
		if (x == null) return null;
		if (x.right != null) return min(x.right);
		Node y = x.parent;
		while(y != null && x == y.right) {
			//System.out.println((x == y.right) + "\t" + x.getValue()+"\t" + y.right.getValue());
			x = y;
			y = y.parent;
			//System.out.println((x == y.right) + "\t" + x.getValue()+"\t" + y.right.getValue());
		}
		return y;
	}
	public Node predecessor(int n) {
		Node x = search(root, n);
		if (x == null) return null;
		if (x.left != null) return max(x.left);
		Node y = x.parent;
		while(y != null && x == y.left) {
			x = y;
			y = y.parent;
		}
		return y;
	}		
	public void setCurrent(){
		current = root;
	}
	public void insert(int value) {
		addValue(root, value);
	}
	private void addValue(Node r, int num) {
		if (r != null) {
			if (num > r.getValue()) {
				if (r.right == null) {
					r.right = new Node(num);
					r.right.parent = r;
				} else {
					addValue(r.right, num);
				}
			}
			if (num < r.getValue()) {
				if (r.left == null) {
					r.left = new Node(num);
					r.left.parent = r;
				}else {
					addValue(r.left, num);
				}
			}
		}
	}
	public Node delete(Node z) {
		if (z == null) return null;
		Node y, x = null;
		if (z.left == null || z.right == null) {
			y = z;
		} else {
			y = successor(z.getValue());
		}
		if (y.left != null) x = y.left;
		else x = y.right;
		if (x != null) {
			x.parent = y.parent;
		}
		if (y.parent == null) {
			root = x;
		}
		else if (y == y.parent.left) {//if y is the left child of it parent
			y.parent.left = x;
		} else {
			y.parent.right = x;
		}
		if (y != z) {
			z.setValue(y.getValue());
		}
		return y;
	}




	public int label(Node r) {
		if (r != null) {
			r.h(0);
			if (r.right != null) {
				r.h(Math.max(r.height, label(r.right)));
			}
			if (r.left != null) {
				r.h (Math.max(r.height, label(r.left)));
			}
		}
		return ++r.height;
	}
	public void printLabel(Node r) {
		if (r != null) {
			System.out.println(r.getValue() + "  " + r.getHeight());
			printLabel(r.right);
			printLabel(r.left);
		}
	}
	public Node find(Node r) {
		setCurrent();
		return findNode(r);
	}
	private Node findNode(Node r) {
		label(root);
		if (r != null) {
			if (r.left != null && r.right != null) {
				if (Math.abs(r.right.height - r.left.height) > 1) {
					if (r.height < current.height)
						current = r;
				}
				findNode(r.right);
				findNode(r.left);
			}
			if (r.left != null ^ r.right != null) {
				if (r.left != null &&  r.left.height > 1) {
					if (r.left.height < current.height)
						current = r;
					findNode(r.left);
				}
				if (r.right != null &&  r.right.height > 1) {
					if (r.right.height < current.height)
						current = r;
					findNode(r.right);
				}
			}
							
		}
		return current;
	}
	public void makeAVL() {
		while(!avl(root)) {
			System.out.println(avl(root) + "\tunbalance\t" + find(root).getValue());
			restructure(find(root));
			
		}
	}
	public boolean avl(Node r) {
		label(r);
		if (r != null) {
			if (r.right != null ^ r.left != null) {
				if (r.left == null) {
					if (r.right.height > 1 || !avl(r.right)) {
						return false;
					}
				}
				if (r.right == null) {
					if (r.left.height > 1 || !avl(r.left)) 
						return false;
				}
			}
			if (r.right != null && r.left != null) {
				if (Math.abs(r.right.height - r.left.height) > 1) 
					return false;
				if (!avl(r.right) || !avl(r.left)) {
					return false;
				}
			}


		}
		return true;
	}
	
	public void restructure(Node z) {
		int temp = z.getValue();
		delete(z);
		insert(temp);
		label(root);	
				
			
	}
	
	public void getChildren(Node r) {
		if (r != null) {
			child.add(r.getValue());
			getChildren(r.right);
			getChildren(r.left);
		}			
	}
		
			
			


	public String toString() {
		String output= "";
		if (current != null) {
						
			Node past = current;
			current = current.left;
			output += toString();
			current = past;
			output += current.getValue() + " ";
			
			past = current;
                        current = current.right;
                        output += toString();
                        current = past;
			
		}
		output = output.substring(0, output.length());
		return output;

	}
		




}


