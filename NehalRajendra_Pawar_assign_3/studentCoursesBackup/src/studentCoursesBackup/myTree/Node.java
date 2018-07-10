package studentCoursesBackup.myTree;

import studentCoursesBackup.other.PassParameter;
import java.util.*;

public class Node implements SubjectI ,ObserverI ,Cloneable
{
	private int Bnumber;
	private List<String> courses = new ArrayList<>();
	public Node left,right;
	private List<Node> backupNodesList = new ArrayList<>();

	public Node() {
		left = null;
		right = null;
		Bnumber = 0;
		//courses  = null;
	}
	
	public void setBnumber(int Bnumber) {
		this.Bnumber = Bnumber;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public int getBnumber() {
		return Bnumber;
	}
	public List<String> getCourses() {
		return courses;
	}
	public List<Node> getbackupNodesList() {
		return backupNodesList;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		Node node1=new Node();
		node1.Bnumber=Bnumber;
		node1.courses=new ArrayList<>(courses);
		return node1;
	}
	@Override
	public void registerObserver(Node observer) {
		backupNodesList.add(observer);
	}
	@Override
	public void notifyall(PassParameter P) {
		
		for(Node node : backupNodesList) {
			node.updateall(P);
		}
	}
	@Override
	public void removeObserver(Node observer)
	{

	}
	@Override
	public void updateall(PassParameter P)
	{		
		if(P.getNotifyType()==PassParameter.NotifyType.Update)		
		courses.add(P.getcourse());
		else if(P.getNotifyType()==PassParameter.NotifyType.Delete)
		courses.remove(P.getcourse());
	}
}