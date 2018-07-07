package studentCoursesBackup.driver;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.MyLogger;
import java.util.*;

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
	System.err.println("Third argument cannot be parse to integer.");
	System.exit(1);
	}
        
        FileProcessor F1 = new FileProcessor();
        List<String> zoom = new ArrayList<>();
	int count;
        Results Re = new Results();
	
	//Read file and add to array
	
        zoom = F1.openFile(INPUTFILE);
      	//System.out.println(zoom);
	//Read array in loop and parse
	
	int bNumber;
        for (String temp : zoom)
        {
		String arr[] = temp.split(":");
		bNumber = Integer.parseInt(arr[0]);
	}
	
    }
}