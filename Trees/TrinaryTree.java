/**
 * 
 * @author Kaushik
 * Class for Ternary Tree
 */

class TrinaryTreeNode {
  //Not using Setters to improve readability.
  int data;
  TrinaryTreeNode left;
  TrinaryTreeNode middle;
  TrinaryTreeNode right;
 /**
  * Constructor of Node
  * @param data
  */
  public TrinaryTreeNode(int data) {
    this.data = data;
  }
  
  public int getData()
  {
	  return data;
  }
  
  public TrinaryTreeNode getLeftChild()
  {
	  return left;
  }
  
  
  public TrinaryTreeNode getRightChild()
  {
	  return right;
  }

  public TrinaryTreeNode getMiddleChild()
  {
	  return middle;
  }
}

class TrinaryTree {
  TrinaryTreeNode root;
  /**
   * for a Tree with No Nodes
   */
  public TrinaryTree()
  {
	  
  }
  
  public TrinaryTreeNode getRoot()
  {
	  return root;
  }
  /**
   * Constructor of tree .Instantiates root Node
   * @param data
   */
  public TrinaryTree(int data) {
    this.root = new TrinaryTreeNode(data);
  }

/**
 * Function to insert into ternary tree.
 * It Finds the correct place by using <,>,= comparison
 * @param insertdata data to be inserted
 * @param node    The root of Tree
 * @return TrinaryTreeNode
 */
  public TrinaryTreeNode insert(int insertdata, TrinaryTreeNode node) {
	  if (node == null) {
	      node = new TrinaryTreeNode(insertdata);
	    }
	  else if (insertdata < node.getData()) {
      node.left = insert(insertdata, node.getLeftChild());
    } else if (insertdata == node.getData()) {
      node.middle = insert(insertdata, node.getMiddleChild()) ;
    } else {
      node.right = insert(insertdata, node.getRightChild());
    }
    return node;
  }
 /**
  * Function to delete from a ternary tree
  * @param deleteData The data to be deleted
  * @param node The root of tree
  * @return
  */
  public TrinaryTreeNode delete(int deleteData, TrinaryTreeNode node) {
	     if (node == null)
		    return null;
		  if (node.getData() == deleteData) {
		    // three child nodes are all NULL
		    if (node.getLeftChild() == null && node.getRightChild() == null && node.getMiddleChild() == null) {
		    	node =null;
		    	return node;
		    }
		    if (node.getMiddleChild()!=null) {
		      node.middle = delete(deleteData,node.getMiddleChild());
		    }
		    else {
		      if (node.getLeftChild()!=null && node.getRightChild()!=null) {  // both left and right exist
		    	  TrinaryTreeNode successorNode = findMin(node.getRightChild());
		          node.data = successorNode.getData();
		          node.right = delete(successorNode.getData(),node.getRightChild());
		      }
		      else if (node.getLeftChild() !=null) {    // right child is empty
		    	 node = node.getLeftChild();
		      }
		      else {                //left child is empty
		    	  if(node == getRoot()) 
		    		  root = node.getRightChild();
		    	  
		    	  node = node.getRightChild();
		    	  
		      }
		    }
		  }
		  else if (node.getData() < deleteData)
		    node.right = delete(deleteData,node.getRightChild());
		  else
		    node.left = delete(deleteData,node.getLeftChild());

		  return node;
  }  
  
  /**
   * Find Minimum of on the subtree of given node.
   * @param node The parent Node
   * @return TrinaryTreeNode The Minimum Node of Subtree
   */
  public TrinaryTreeNode findMin(TrinaryTreeNode node) {
	  if(node == null)
	       return null;
	else if (node.getLeftChild() == null)
		return node;
	else
		return findMin(node.getLeftChild());
	  }
  /**
   * Helper function to print Inorder traversal of trinary Tree Used for Testing
   * @param root
   */
  public static void print(TrinaryTreeNode root)
  {
	  if(root!=null)
	  {
		  
		  print(root.getLeftChild());
		  System.out.print(root.getData()+" ");
		  print(root.getMiddleChild());
		  print(root.getRightChild());
	  }
  }
}