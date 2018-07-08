package studentCoursesBackup.util;
import java.util.*;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder
{
	Node Root;
	Node Root1 , Root2;
	
	public TreeBuilder() {
		Root = null;
		Root1 = null;
		Root2 = null;
	}

	public Node createNode(String course,int Bnumber) {
		List<String> list = new ArrayList<>();
		Node node = new Node();
		node.setBnumber(Bnumber);	
		
		list.add(course);
		node.setCourses(list);
		
		return node;
	}
	
	public void insertNodes(Node node) 
	{
    	Root = insertNode(Root, node);
    	List<Node> list = new ArrayList<>();
    	list=node.getbackupNodesList();
	Root1 = insertNode(Root1, list.get(0));
    	Root2 = insertNode(Root2, list.get(1));
    	}
	
	private Node insertNode(Node root, Node node) {
		
		if(root == null) {
			root = node;
			return root;
		}
	if (node.getBnumber() > root.getBnumber())
        	root.right = insertNode(root.right, node);
        else if (node.getBnumber() < root.getBnumber())
        	root.left = insertNode(root.left, node);
        
 
        return root;
	}
}