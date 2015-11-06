

public class TernaryTreeTester {

	public static void main(String[] args) {
        
		  TrinaryTree tree= new TrinaryTree(5);
		  tree.insert(4, tree.getRoot());
		  tree.insert(9, tree.getRoot());
		  tree.insert(5, tree.getRoot());
		  tree.insert(7, tree.getRoot());
		  tree.insert(2, tree.getRoot());
		  tree.insert(2, tree.getRoot());
		  TrinaryTree.print(tree.getRoot());
		  System.out.println();
		  tree.delete(5, tree.getRoot());
		  TrinaryTree.print(tree.getRoot());
		  System.out.println();
		  tree.delete(5, tree.getRoot());
		  TrinaryTree.print(tree.getRoot());
		  System.out.println();
	}

}
