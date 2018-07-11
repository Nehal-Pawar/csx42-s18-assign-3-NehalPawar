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
	Node Node_orig=new Node();
	Node backup_Node_1= null, backup_Node_2= null;

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
		Node_orig=treeBuilder.BnumberSearch(Bnumber);
		
		if(Node_orig==null){
		
		Node_orig= treeBuilder.createNode(values[1],Bnumber);
		backup_Node_1= (Node) Node_orig.clone();		
		backup_Node_2= (Node) Node_orig.clone();
		Node_orig.registerObserver(backup_Node_1);
		Node_orig.registerObserver(backup_Node_2);
		treeBuilder.insertNodes(Node_orig);
		}
		else
		{
			Pass.setcourse(values[1]);
			Pass.setNotifyType(PassParameter.NotifyType.Update);
			Node_orig.update(Pass);
			Node_orig.notifyAll(Pass);			
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
		
	FileProcessor F2 = new FileProcessor();
	Set<String> zoom2 = new LinkedHashSet<>();
        zoom2 = F2.openFile(DELETEFILE);
	 for (String temp : zoom2)
	{
		if(temp!=null)
		{
			String values[] = temp.split(":");
			Bnumber = Integer.parseInt(values[0]);
			Node_orig=treeBuilder.BnumberSearch(Bnumber);
			Pass.setcourse(values[1]);
			Pass.setNotifyType(PassParameter.NotifyType.Delete);
			Node_orig.update(Pass);
			Node_orig.notifyAll(Pass);
		}
	}

	Results Re = new Results();
	Results Re1 = new Results();
	Results Re2 = new Results();
	treeBuilder.printNodes(Re,Re1,Re2);
	Re.writeToFile(OUTPUTFILE1);
	Re1.writeToFile(OUTPUTFILE2);
	Re2.writeToFile(OUTPUTFILE3);
    }
}