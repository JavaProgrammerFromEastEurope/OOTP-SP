public class BinTree {
	Tree tree;

	public BinTree() {
	}
	public String search (int key){
		if (tree != null) {
			Tree uk = tree;
			Tree next = uk;
			while (next != null) {
				uk = next;
				if (key > uk.key) {
					next = uk.right;
				}
				else if (key < uk.key) {
					next = uk.left;
				}
				else
					return uk.value;
			}
		}
		return "null";
	} 
	public void add(int key, String value) {
		Tree temp = new Tree();
		temp.key = key;
		temp.value = value;
		if (tree == null) {
			tree = temp;
		}
		else {
			Tree uk = tree;
			Tree next = uk;
			while (next != null) {
				uk = next;
				if (key > uk.key) {
					next = uk.right;
				}
				else if (key < uk.key) {
					next = uk.left;

				}
				else{
					uk.value = temp.value;
					return;}
					
			}
			if (key > uk.key) {
				uk.right = temp;
			}
			else if (key < uk.key) {
				uk.left = temp;

			}
		}
	}

	private class Tree {
		int key;
		String value;
		Tree left, right;

	}
}