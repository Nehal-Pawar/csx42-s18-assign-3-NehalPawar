package studentCoursesBackup.util;

import java.util.*;
import studentCoursesBackup.myTree.Node;

public class TreeBuilder
{
    Node Root;
    Node Root1, Root2;

    public TreeBuilder()
    {
        Root = null;
        Root1 = null;
        Root2 = null;
    }

    public Node createNode(String course, int Bnumber)
    {
        Node node = new Node();
        node.setBnumber(Bnumber);
        List<String> list = new ArrayList<>();
        list.add(course);
        node.setCourses(list);

        return node;
    }

    public void insertNodes(Node node)
    {
        Root = insertNode(Root, node);
        List<Node> list = new ArrayList<>();
        list = node.getbackupNodesList();
        Root1 = insertNode(Root1, list.get(0));
        Root2 = insertNode(Root2, list.get(1));
    }

    private Node insertNode(Node root, Node node)
    {

        if (root == null)
        {
            root = node;
            return root;
        }
        if (node.getBnumber() > root.getBnumber())
            root.right = insertNode(root.right, node);
        else if (node.getBnumber() < root.getBnumber())
            root.left = insertNode(root.left, node);


        return root;
    }

    public void printNodes(Node rootNode, Results result)
    {
        if (rootNode != null)
        {
            PrintNodes(rootNode.left, result);
            result.storeNewResult(rootNode.getBnumber() + " " + rootNode.getCourses());
            PrintNodes(rootNode.right, result);
        }
    }

    //https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
    public Node search(Node root, int Bnumber)
    {
        if (root == null)
            return null;
        else if (root.getBnumber() == Bnumber)
            return root;
        else if (root.getBnumber() > Bnumber)
            return search(root.left, Bnumber);
        else
            return search(root.right, Bnumber);
    }

    public Node BnumberSearch(int Bnumber)
    {
        Node found = search(Root, Bnumber);
        if (found != null)
            return found;
        return null;
    }
}