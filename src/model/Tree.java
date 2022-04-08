package model;

public class Tree {

	private Node root;

	public void add(int key, String value) {

		if (root == null) {

			root = new Node(key, value);
		} else {

			root.insert(key, value);
		}

	}

	// Activador del metodo recursivo
	public void triggerInOrder() {

		inorder(root);

	}

	// Recursivo
	public void inorder(Node node) {
		// Caso base
		if (node == null) {
			return;
		}

		// Recursivo
		inorder(node.getLeft());

		System.out.print(node.getKey() + ", ");

		inorder(node.getRight());

	}

	public Node triggerSearch(int key) {

		return search(root, key);

	}

	public Node search(Node node, int key) {

		if (node == null) {

			return null;

		}

		if (node.getKey() == key) {

			return node;
		}

		/////////// procedimientos

		if (key < node.getKey()) {

			return search(node.getLeft(), key);

		} else {

			return search(node.getRight(), key);
		}

	}

	public Node getMin(Node current) {

		if (current.getLeft() == null) {
			return current;
		} else {
			return getMin(current.getLeft());
		}
	}

	public Node getMax(Node current) {

		if (current.getRight() == null) {
			return current;
		} else {
			return getMin(current.getRight());
		}
	}

	public void triggerDelete(int key) {
		if (root != null) {
			root = delete(root, key);
		}

	}

	public Node delete(Node current, int key) {

		if (current.getKey() == key) {

			if (current.getLeft() == null && current.getRight() == null) {
				return null;
			} else if (current.getLeft() != null && current.getRight() != null) {
				
				Node sucess = getMin(current.getRight());
				
				Node newRightTree = delete(current.getRight(), sucess.getKey());
				
				sucess.setLeft(current.getLeft());
				sucess.setRight(newRightTree);
				
				return sucess;
				

			} else if (current.getLeft() != null) {

				return current.getLeft();
				
			} else  {

				return current.getRight();
			}

		} else if (key < current.getKey()) {

			Node newLeftTree = delete(current.getLeft(), key);
			current.setLeft(newLeftTree);

		} else {
			Node newRightTree = delete(current.getRight(), key);
			current.setRight(newRightTree);
		}

		return current;
	}

}
