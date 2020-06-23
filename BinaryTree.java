public class BinaryTree {

	Node root;

	public void addNode(int key, String name) {
		// so lets start with a new done
		Node newNode = new Node(key, name);

		// if the root is null, then newNode becomes root of the tree
		if (root == null) {

			root = newNode;

			System.out.println("Root Node has been added"+root);
		} else {
			// nodes that we're going to be working with, focus node will be added, then
			// we're going to check,
			// what do we do with the new node, is it a left or right node,
			Node focusNode = root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				parent = focusNode;
				// if key for our new node is less than the key for our existing node
				// then it has to be the left side as it is a Binary tree.
				if (key < focusNode.key) {

					focusNode = focusNode.leftNode;
					// if the focus node is null and there are no children then it is a child node
					// of the parent
					if (focusNode == null) {

						parent.leftNode = newNode;

						return;
					}
				} else {
					// if it is not any of the above conditions that test for left nodes
					// then it must be a right node
					focusNode = focusNode.rightNode;
					// if the right child has no children
					if(focusNode == null){
						parent.rightNode = newNode;
						return;
					}
				}
			}
		}

	}

	/************************************************************************************************************************************
	 * **********************************************************************************************************************************
	 * **************** LETS TRAVERSE OUR NEW BINARY TREE
	 * *******************************************************************************
	 * **********************************************************************************************************************************
	 ************************************************************************************************************************************/

	// IN ORDER TRAVERSAL

	public void inOrder(Node focusNode) {
		if (focusNode != null) {
			// so lets think about this, if there's a left node print it,
			// if theres a right node print it..
			inOrder(focusNode.leftNode);
			System.out.println("Left Node:" + focusNode);
			inOrder(focusNode.rightNode);
			System.out.println("Right Node:" + focusNode);
		}
	}

	public static void main(String[] args) {
		BinaryTree myBinaryTree = new BinaryTree();
		myBinaryTree.addNode(1, "First Node added");
		myBinaryTree.addNode(2, "Second Node Added");
		myBinaryTree.addNode(3, "Third Node Added");
		myBinaryTree.addNode(40, "40");
		myBinaryTree.addNode(50, "50");
		myBinaryTree.addNode(99, "99");
		// now lets traverse and check out print statements
		myBinaryTree.inOrder(myBinaryTree.root);
	}
}

// Lets create out Tree structure
class Node {
	int key;
	String name;
	Node leftNode;
	Node rightNode;

	// constructor for node
	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}
	
    public String toString() {

        return name + " has the key " + key;

    }
}