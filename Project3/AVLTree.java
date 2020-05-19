/*Name: David Kopp
*/

class AVLNode<E extends Comparable<E>> // non-public class
{

private E item;
private AVLNode<E> parent;
private AVLNode<E> left; // leftChild
private AVLNode<E> right; // rightChild
private height; // Optional. Add setter and getter if you use this
public AVLNode(E item) { } // constructor that sets left, right, and parent to null
public AVLNode(E item, AVLNode<E> p, AVLNode<E> lft, AVLNode<E> rt) { } 
// Add public setters and getters for item, parent, leftChild, rightChild, and add a toString() that returns with item in it
}

public class AVLTree<E extends Comparable<E>>
{

private root AVLNode<E>;

public AVLTree() { }
public boolean is Empty() { }
public int size() { }
public int height() { }
public boolean search(E item) { }
public void insert(E item) { } // dups ok
public boolean delete(E item) { }
public boolean isHeightBalanced() { }
public void printPreorder() { }
public void printInorder() { }

private int rheight(TreeNode<E> tree) { }
private TreeNode<E> triNodeRestructure(TreeNode<E> x) { } //DL on moodle
// others as needed
}
