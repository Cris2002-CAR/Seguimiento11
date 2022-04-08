package ui;

import model.Node;
import model.Tree;

public class Main {

	public static void main(String[] args) {
		
		Tree t = new Tree();
		
		t.add(10, "A");
		t.add(-2, "B");
		t.add(4, "C");
		t.add(15, "D");
		t.add(20, "E");
		t.add(-60, "F");
		
		t.triggerInOrder();
		
		Node node = t.triggerSearch(20);
		
		System.out.println();
		
		if(node == null) {
			
			System.out.println("El nodo no se encuentra en el arbol");
			
		}else {
			
			System.out.println(node.getKey()+", "+node.getValue());
		}
		
	}

}
