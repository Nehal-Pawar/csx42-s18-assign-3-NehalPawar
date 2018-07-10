package studentCoursesBackup.myTree;

import studentCoursesBackup.other.PassParameter;

public interface SubjectI {

	public void registerObserver(Node observer);
	public void removeObserver(Node observer);
	public void notifyAll(PassParameter P);
	
}
