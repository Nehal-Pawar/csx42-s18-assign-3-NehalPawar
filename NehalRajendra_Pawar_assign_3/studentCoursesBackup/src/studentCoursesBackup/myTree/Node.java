package studentCoursesBackup.myTree;

import studentCoursesBackup.other.PassParameter;
import java.util.*;

public class Node implements SubjectI ,ObserverI ,Cloneable
{
	private int Bnumber;
	private List<String> courses;
	public Node left,right;
	private List<Node> backupNodesList = new ArrayList<>();

	public Node() {
		left = null;
		right = null;
		Bnumber = 0;
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
		return super.clone();
	}
	@Override
	public void registerObserver(Node observer) {
		backupNodesList.add(observer);
	}
	public void notifyall(PassParameter P) {
		if(P.getNotifyType()==PassParameter.NotifyType.Update)
		for(Node node : backupNodesList) {
			node.updateall(P);
		}
	}
	@Override
	public void removeObserver(Node observer)
	{

	}
	public void updateall(PassParameter P)
	{
		node.getCourses().add(values[1]);
	}
}