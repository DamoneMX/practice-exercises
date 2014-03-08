import java.util.*;
public class BinarySearchTree{
	Node root; 

	private static class Node{
		int data;
		Node left; 
		Node right;
		Node(int newData){
			data = newData;
			left = null;
			right = null;
		}
	}

	public BinarySearchTree(){
		root = null;
	}

	public boolean lookup(int data){
		return lookup(root, data);
	}

	private boolean lookup(Node node, int data){
		if(node == null) return false;
		
		if(node.data == data) return true;
		else if(data < node.data) return lookup(node.left, data);
		else return lookup(node.right, data); //Acuerdate del return, lo sigues olvidando
	}

	public void insert(int data){
		root = insert(root, data);
	}

	/*
	 * This method is assuming that the value that is being inserted is not 
	 * present in the tree.
	 */
	public Node insert(Node node, int data){
		if(node == null) 
			node = new Node(data);
		else{
			if(data < node.data) //writing reference, if it's old nothing changes : on new, it updates the references
				node.left = insert(node.left, data);		
			else 
				node.right = insert(node.right, data);		
		}
		return node;
	}

	public static void inorderTraversal(Node node, LinkedList<Integer> list){
		if(node == null) return;

		inorderTraversal(node.left, list);
		list.add(node.data);
		inorderTraversal(node.right, list);
	}

	//~~~~~~ Deletion Methods	

	public void deleteMin(){
		if(isEmpty()) return;
		root = deleteMin(root);	
	}

	/*
	 *Delete min, find lowest value in subtree and set as new left.
	 *
	 *
	 */
	private Node deleteMin(Node x){
		if(x.left == null) return x.right; //left == null reflects we've reached minimal value in tree

		x.left = deleteMin(x.left); 
		//x.count --> when keeping count, update it here
		return x;
	}

	public void delete(int key){
		if(isEmpty()) return;
		root = delete(root, key);
	}	

	private Node delete(Node x, int key){
		if(x == null) return null;
		
		if(key < x.val) delete(x.left, key);
		else if(key > x.val) delete(x.right, key);
		else{
			//Case 1 and 2: Node has no children or only a left child
			if(x.right == null) return x.left;

			Node temp = x;
			x.val = min(x.right);
			x.right = deleteMin(t.right);
			x.left = temp.left;
		}
		//x.count --> update here
		return x;	
	}
	
	/***********************************************************************
	    *  Min, max, floor, and ceiling
	    ***********************************************************************/

	public int min() {
		if (isEmpty()) return null;
		return min(root).key;
	} 

	private Node min(Node x) { 
		if (x.left == null) 
			return x; 
		else                
			return min(x.left); 
	} 


	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(6);
		bst.insert(8);
		bst.insert(3);
		bst.insert(9);

		LinkedList<Integer> list = new LinkedList<Integer>();
		inorderTraversal(bst.root, list);
		for(int data : list)
			System.out.print(data + " -> ");
	}

}
