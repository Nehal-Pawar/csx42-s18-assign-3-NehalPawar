package studentCoursesBackup.driver;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.MyLogger;
import java.util.*;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.other.PassParameter;

public class Driver
{
    public static void main(String[] args)
    {
        String INPUTFILE = args[0];
        String DELETEFILE = args[1];
        String OUTPUTFILE1 = args[2];
        String OUTPUTFILE2 = args[3];
        String OUTPUTFILE3 = args[4];
        String DEBUGVALUE = args[5];

	//Read all the parameters and vlaidate if all are taken thorugh command line

	for(int i=0;i<args.length;i++)
 	if (args[i].equals("${arg"+i+"}"))
        {
		//System.out.println(i+" "+INPUTFILE );
            System.err.println("incorrect args passed, Expected <input.txt> <delete.txt> <output1.txt> <output2.txt> <output3.txt> <debug value>. \n exiting \n");
            System.exit(1);
        }
	try{
        MyLogger.setDebugValue(Integer.parseInt(args[5]));}
	catch(Exception e){
	System.err.println("fifth argument cannot be parse to integer to set debug value.");
	System.exit(1);
	}
        
        
	TreeBuilder treeBuilder = new TreeBuilder();
        	
        PassParameter Pass=new PassParameter();
	Node node;
	Node backup1 = null, backup2 = null;

	//Read file and add to array
	FileProcessor F1 = new FileProcessor();
	Set<String> zoom = new LinkedHashSet<>();
        zoom = F1.openFile(INPUTFILE);
      	//Read array in loop and parse
	
	int Bnumber;
        for (String temp : zoom)
        {
		if(temp!=null)
		{
		try
		{
		String values[] = temp.split(":");
		Bnumber = Integer.parseInt(values[0]);
		node=treeBuilder.BnumberSearch(Bnumber);
		
		if(node==null){
		
		node = treeBuilder.createNode(values[1],Bnumber);
		backup1 = (Node) node.clone();		
		backup2 = (Node) node.clone();
		node.registerObserver(backup1);
		node.registerObserver(backup2);
		treeBuilder.insertNodes(node);
		}
		else
		{
			Pass.setcourse(values[1]);
			Pass.setNotifyType(PassParameter.NotifyType.Update);
			node.updateall(Pass);
			node.notifyall(Pass);			
		}
		}
		catch(CloneNotSupportedException e) 
		{
			System.out.println("Error while cloning.");
			e.printStackTrace();
			System.exit(0);
		}					
		}
	}	
	treeBuilder.Display();	
	/*
	FileProcessor F2 = new FileProcessor();
	Set<String> zoom2 = new LinkedHashSet<>();
        zoom2 = F2.openFile(DELETEFILE);
	 for (String temp : zoom2)
	{
		if(temp!=null)
		{
			String values[] = temp.split(":");
			Bnumber = Integer.parseInt(values[0]);
			node=treeBuilder.BnumberSearch(Bnumber);
			Pass.setcourse(values[1]);
			Pass.setNotifyType(PassParameter.NotifyType.Delete);
			node.updateall(Pass);
			node.notifyall(Pass);
		}
	}
	*/
    }
}