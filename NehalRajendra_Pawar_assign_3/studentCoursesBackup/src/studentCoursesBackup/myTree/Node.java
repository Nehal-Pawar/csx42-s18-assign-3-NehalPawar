package studentCoursesBackup.myTree;
import java.util.*;

public class Node
{
	private int Bnumber;
	private List<String> courses;
	public Node left,right;

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
}