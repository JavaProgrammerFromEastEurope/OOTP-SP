public class Main {

	public static void main(String[] args){

		BinTree tree = new BinTree();
		tree.add(5, "Пять");
		tree.add(3, "Три");
		tree.add(1, "Один");
		tree.add(2, "Два");
		tree.add(7, "Семь");
		tree.add(8, "Восемь");
		tree.add(10, "Десять");
		tree.add(9, "Девять");
	System.out.println(tree.search(9));
	}


}