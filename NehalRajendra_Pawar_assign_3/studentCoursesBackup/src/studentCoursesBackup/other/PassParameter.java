package studentCoursesBackup.other;

public class PassParameter
{
	public static enum NotifyType
	{
		Update, Delete
	};
	
	private String course;
	int Bnumber;
	private NotifyType debugLevel;

	public void setcourse(String course1)
	{
		course=course1;
	}
	
	public String getcourse()
	{
		return course;
	}
    public void setNotifyType(NotifyType levelIn)
    {
        debugLevel = levelIn;
    }
	public NotifyType getNotifyType()
	{
		return debugLevel;
	}
		
}