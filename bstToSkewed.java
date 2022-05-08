

class Node{
	int value;
	Node left,right;
	
	Node(int item){
		value = item;
		left = right = null;
	}
}
public class bstToSkewed {

	public Node node ;
	public Node pNode = null;
	public Node hNode = null;
	
	public void InitSkewedTree(Node root,int key) {
		if(root == null)
			return;
		if(key > 0)
			InitSkewedTree(root.right,key);
		else
			InitSkewedTree(root.left,key);
		
		Node rightNode = root.right;
		Node leftNode = root.left;
		
		if(hNode == null) {
			hNode = root;
			root.left = null;
			pNode = root;
		}
		else {
			pNode.right = root;
			root.left = null;
			pNode = root;
		}
		
		if(key>0)
			InitSkewedTree(leftNode,key);
		else
			InitSkewedTree(rightNode,key);
			
	}
	
	public void display(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.value + " ");
		display(root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bstToSkewed tree = new bstToSkewed();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);
		
		int key = 0;
		tree.InitSkewedTree(tree.node, key);
		System.out.println("Rightly Skewed tree is as following");
		tree.display(tree.hNode);
	}

}
