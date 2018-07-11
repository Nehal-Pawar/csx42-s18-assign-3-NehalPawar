package studentCoursesBackup.util;

import java.util.*;
import studentCoursesBackup.myTree.Node;

public class TreeBuilder
{
    Node Node_orig;
    Node backup_Node_1, backup_Node_2;

    public TreeBuilder()
    {
        Node_orig= null;
        backup_Node_1 = null;
        backup_Node_2 = null;
    }
    /*
     * create new node and assign values
     * @param course 
     * @param Bnumber
     */
    public Node createNode(String course, int Bnumber)
    {
        Node node = new Node();
        node.setBnumber(Bnumber);
        List<String> list = new ArrayList<>();
        list.add(course);
        node.setCourses(list);

        return node;
    }

    /*
     * code calls inserets node to tree 1 and its backup reference tree 2 tree3
     * @param node
     */
    public void insertNodes(Node node)
    {
        Node_orig= insertNode(Node_orig, node);
        List<Node> list = new ArrayList<>();
        list = node.getbackupNodesList();
        backup_Node_1 = insertNode(backup_Node_1, list.get(0));
        backup_Node_2 = insertNode(backup_Node_2, list.get(1));
    }

    /*
    * code inserets node to tree
    * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
    * @param root node
    * @param current node
    */
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

     /*call individual print tree
     * https://stackoverflow.com/questions/29735465/printing-binary-search-tree-inorder-recursively
     * @param result
     */	
    public void printtree(Node rootNode, Results result)
    {
        if (rootNode != null)
        {
            printtree(rootNode.left, result);
            result.storeNewResult(rootNode.getBnumber() + " " + rootNode.getCourses());
            printtree(rootNode.right, result);
        }
    }

    /*call print all 3 trees
     * @param result
     * @param result1
     * @param result2
     */
    public void printNodes(Results result, Results result1, Results result2)
    {
        printtree(Node_orig, result);
        System.out.println();
        printtree(backup_Node_1, result1);
        System.out.println();
        printtree(backup_Node_2, result2);
    }

    /*search Bnumber and if exist return it or return null
     *     https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     *     @param node
     *     @param bnumber
     */
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
        Node found = search(Node_orig, Bnumber);
        if (found != null)
            return found;
        return null;
    }
}
 
 