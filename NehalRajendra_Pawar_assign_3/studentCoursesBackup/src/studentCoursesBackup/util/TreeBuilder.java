package studentCoursesBackup.util;
import java.util.*;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder
{
	public Node createNode(String course,int Bnumber) {
		Node node = new Node();
		node.setBnumber(Bnumber);
		
		List<String> list = new ArrayList<>();
		list.add(course);
		node.setCourses(list);
		
		return node;
	}
}