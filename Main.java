public class Main{
	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		tree.makeTree(numbers);
		
		tree.label(tree.root);
		tree.printLabel(tree.root);
		

		

		
		//tree.delete(tree.search(tree.root, 90));
		//tree.insert(18);
		System.out.println("delete/ insert");
		tree.label(tree.root);
		tree.printLabel(tree.root);

		tree.makeAVL();
		System.out.println("balancing");
		tree.printLabel(tree.root);

		
		
		tree.setCurrent();
		System.out.println(" ** " +  tree.toString());
	}
}
