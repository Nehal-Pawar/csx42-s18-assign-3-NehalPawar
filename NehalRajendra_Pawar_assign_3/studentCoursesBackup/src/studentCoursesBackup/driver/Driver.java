package fourWayStreetLights.driver;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.Results;
import fourWayStreetLights.util.MyLogger;
import fourWayStreetLights.service.StretLightsContext;
import fourWayStreetLights.service.*;
import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
        String INPUTFILE = args[0];
        String OUTPUTFILE = args[1];
 	if ((INPUTFILE.equals("${arg0}")) || (OUTPUTFILE.equals("${arg1}")) || (args[2].equals("${arg2}")))
        {
            System.err.println("incorrect args passed, Expected <input.txt> <output.txt> <debug value>. \n exiting \n");
            System.exit(1);
        }
	try{
        MyLogger.setDebugValue(Integer.parseInt(args[2]));}
	catch(Exception e){
	System.err.println("Third argument cannot be parse to integer.");
	System.exit(1);
	}
        StretLightsContext Obj1 = new StretLightsContext();
        FileProcessor F1 = new FileProcessor();
        List<String> zoom = new ArrayList<>();
	int count;
        Results Re = new Results();
	/*
	//Read file and add to array
	*/
        zoom = F1.openFile(INPUTFILE);
      	/*
	//Read array in loop and parse
	*/

        for (String temp : zoom)
        {
            String[] splited = temp.split(" ");
            switch (splited[0])
            {
                case "North":
                    if (splited[1].equals("Green"))
                    {
			count=NorthStreetLight.NorthCars.size();
			if(StretLightsContext.CurrentState instanceof NorthStreetLight){
			 Results.storeNewResult("Context is already in green");
			}
			else{			
			if(count>=2)
                        Results.storeNewResult("Cars in Queue before:North " + NorthStreetLight.NorthCars);                        
			Obj1.goNorth();
                        Obj1.RemoveCars();
			}
			if(count>=1)
                        Results.storeNewResult("Cars in Queue after:North " + NorthStreetLight.NorthCars);
			
                    }
                    else if (splited[1].equals("Red"))
                    {
                        if(StretLightsContext.CurrentState instanceof NorthStreetLight||StretLightsContext.CurrentState instanceof DefaultStreetLight)
                        Obj1.goRed();
			else
			Results.storeNewResult("North is Already Red. No State Change");
                    }
                    else
                    {
                        String[] splitedCars = splited[1].split(",");
                        NorthStreetLight.NorthCars.addAll(Arrays.asList(splitedCars));
			if(StretLightsContext.CurrentState instanceof NorthStreetLight){
			Results.storeNewResult("Cars in Queue after new car added:North " + NorthStreetLight.NorthCars);
		        Obj1.RemoveCars();
			Results.storeNewResult("Cars in Queue after new car added:North " + NorthStreetLight.NorthCars);
			}
                    }
                    break;

                case "East":
                    if (splited[1].equals("Green"))
                    {
			count=EastStreetLight.EastCars.size();
			if(StretLightsContext.CurrentState instanceof EastStreetLight){
			 Results.storeNewResult("Context is already in green");
			}
			else{
			if(count>=2)
                        Results.storeNewResult("Cars in Queue before:East " + EastStreetLight.EastCars);
                        Obj1.goEast();
                        Obj1.RemoveCars();}
			if(count>=1)
                        Results.storeNewResult("Cars in Queue after:East " + EastStreetLight.EastCars);
                    }
                    else if (splited[1].equals("Red"))
                    {
                        if(StretLightsContext.CurrentState instanceof EastStreetLight||StretLightsContext.CurrentState instanceof DefaultStreetLight)
                        Obj1.goRed();
			else
			Results.storeNewResult("East is Already Red. No State Change");
                    }
                    else
                    {
                        String[] splitedCars = splited[1].split(",");
                        EastStreetLight.EastCars.addAll(Arrays.asList(splitedCars));
			if(StretLightsContext.CurrentState instanceof EastStreetLight){
			Results.storeNewResult("Cars in Queue after new car added:North " + EastStreetLight.EastCars);
		        Obj1.RemoveCars();
			Results.storeNewResult("Cars in Queue after new car added:North " + EastStreetLight.EastCars);
			}

                    }
                    break;
                case "West":
                    if (splited[1].equals("Green"))
                    {
			count=WestStreetLight.WestCars.size();
			if(StretLightsContext.CurrentState instanceof WestStreetLight){
			 Results.storeNewResult("Context is already in green");
			}
			else{
			if(count>=2)
                        Results.storeNewResult("Cars in Queue before:West " + WestStreetLight.WestCars);
                        Obj1.goWest();
                        Obj1.RemoveCars();}
			if(count>=1)
                        Results.storeNewResult("Cars in Queue after:West " + WestStreetLight.WestCars);
                    }
                    else if (splited[1].equals("Red"))
                    {
                        if(StretLightsContext.CurrentState instanceof WestStreetLight||StretLightsContext.CurrentState instanceof DefaultStreetLight)
                        Obj1.goRed();
			else
			Results.storeNewResult("West is Already Red. No State Change");

                    }
                    else
                    {
                        String[] splitedCars = splited[1].split(",");
                        WestStreetLight.WestCars.addAll(Arrays.asList(splitedCars));
			if(StretLightsContext.CurrentState instanceof WestStreetLight){
			Results.storeNewResult("Cars in Queue after new car added:North " + WestStreetLight.WestCars);
		        Obj1.RemoveCars();
			Results.storeNewResult("Cars in Queue after new car added:North " + WestStreetLight.WestCars);
			}

                    }
                    break;
                case "South":
                    if (splited[1].equals("Green"))
                    {
			count=SouthStreetLight.SouthCars.size();
			if(StretLightsContext.CurrentState instanceof SouthStreetLight){
			 Results.storeNewResult("Context is already in green");
			}
			else{

			if(count>=2)
                        Results.storeNewResult("Cars in Queue before:South " + SouthStreetLight.SouthCars);
                        Obj1.goSouth();
                        Obj1.RemoveCars();}
			if(count>=1)
                        Results.storeNewResult("Cars in Queue after:South " + SouthStreetLight.SouthCars);
                    }
                    else if (splited[1].equals("Red"))
                    {
			if(StretLightsContext.CurrentState instanceof SouthStreetLight||StretLightsContext.CurrentState instanceof DefaultStreetLight)
                        Obj1.goRed();
			else
			 Results.storeNewResult("South is Already Red. No State Change");
                    }
                    else
                    {
                        String[] splitedCars = splited[1].split(",");
                        SouthStreetLight.SouthCars.addAll(Arrays.asList(splitedCars));
			if(StretLightsContext.CurrentState instanceof SouthStreetLight){
			Results.storeNewResult("Cars in Queue after new car added:North " + SouthStreetLight.SouthCars);
		        Obj1.RemoveCars();
			Results.storeNewResult("Cars in Queue after new car added:North " + SouthStreetLight.SouthCars);
			}
                    }
                    break;
                default:
                    MyLogger.writeMessage("Direction not match", MyLogger.DebugLevel.AllStates);

            }
        }
        Re.writeToFile(OUTPUTFILE);
    }
}