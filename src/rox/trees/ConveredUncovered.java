package rox.trees;

/* Given a binary tree, you need to 
 * check whether sum of all covered elements is equal to sum of all uncovered elements or not.
   In a binary tree, a node is called Uncovered if it appears either on left boundary or right boundary. 
   Rest of the nodes are called covered.

 */
public class ConveredUncovered {

	public static void main(String args[]) {
		Node root = initiateTestData();
		int sumLeft = getSumPerPart(root, true);
		int sumRight = getSumPerPart(root.right, false);
		int sumTree = sumTree(root);

		System.out.println("SUM TREE: " + sumTree);
		int sumCov = sumTree - (sumLeft + sumRight);
		int sumUncov = sumLeft + sumRight;
		System.out.println("SUM COVERED: " + sumCov);
		System.out.println("SUM UNCOVERED: " + sumUncov);

	}

	private static int getSumPerPart(Node root, boolean isLeft) {
		if (root == null)
			return 0;
		if (root.getChild(isLeft) == null)
			return root.weight + getSumPerPart(root.getChild(!isLeft), isLeft);
		return root.weight + getSumPerPart(root.getChild(isLeft), isLeft);

	}

	private static int sumTree(Node root) {
		if (root == null)
			return 0;
		return root.weight + sumTree(root.left) + sumTree(root.right);
	}

	private static Node initiateTestData() {
		ConveredUncovered cov = new ConveredUncovered();
		ConveredUncovered.Node root = cov.new Node(8);

		root.left = cov.new Node(3);
		root.right = cov.new Node(10);
		root.left.left = cov.new Node(1);
		root.left.right = cov.new Node(6);
		root.left.right.left = cov.new Node(4);
		root.left.right.right = cov.new Node(7);
		root.right.right = cov.new Node(14);
		root.right.right.left = cov.new Node(13);

		return root;
	}

	public class Node {
		private int weight;
		private Node left;
		private Node right;

		public Node getChild(boolean isLeft) {
			if (isLeft)
				return left;
			else
				return right;
		}

		public Node(int weight) {
			this.weight = weight;

		}

	}
}