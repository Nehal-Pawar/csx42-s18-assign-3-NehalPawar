package studentCoursesBackup.myTree;

import studentCoursesBackup.other.PassParameter;
import java.util.*;

public class Node implements SubjectI, ObserverI, Cloneable
{
	private int Bnumber;
    private List<String> courses = new ArrayList<>();
    public Node left, right;
    private List<Node> backupNodesList = new ArrayList<>();

    public Node()
    {
        left = null;
        right = null;
        Bnumber = 0;       
    }

    public void setBnumber(int Bnumber)
    {
        this.Bnumber = Bnumber;
    }

    public void setCourses(List<String> courses)
    {
        this.courses = courses;
    }

    public int getBnumber()
    {
        return Bnumber;
    }

    public List<String> getCourses()
    {
        return courses;
    }

    /*
     * get the listner list
     */
    public List<Node> getbackupNodesList()
    {
        return backupNodesList;
    }

    /*
     * override the clone method from Cloneable
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        Node node1=new Node();
        node1.Bnumber=Bnumber;
        node1.courses=new ArrayList<>(courses);
        return node1;
    }

    /*
     * add the listner list i.e store backup tree nodes reference
     */
    @Override
    public void registerObserver(Node observer)
    {
        backupNodesList.add(observer);
    }

    /*
     * call update on all the listeners i.e reference nodes stored as backups
     * @param PassParameter p
     */
    @Override
    public void notifyAll(PassParameter P)
    {
        for (Node node : backupNodesList)
        {
            node.update(P);
        }
    }

    public void removeObserver(Node observer)
    {

    }

    /*
     * update method makes changes to listeners whoses reference is stored and based on type of update
     * @param PassParameter p
     */
    @Override
        public void update(PassParameter P)
        {
            if (P.getNotifyType() == PassParameter.NotifyType.Update)
                courses.add(P.getcourse());
            else if (P.getNotifyType() == PassParameter.NotifyType.Delete)
                courses.remove(P.getcourse());
        }
}
