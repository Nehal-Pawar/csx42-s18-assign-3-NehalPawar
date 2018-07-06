
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf NehalRajendra_Pawar_assign_2.tar.gz NehalRajendra_Pawar_assign_2

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 6/28/2018]


Provide list of citations (urls, etc.) from where you have taken code
(if any).

Explain the cases for which command line validation has been provided
1.Once signal truns green it doesnot change state when called green again.
2. Only 2 cars can pass if only 1 car is available in queue and signal still green then newly added car can pass successfully.
3. Signal on red cannot go to red again.
4. input.txt not found
5. No cars at signals
6. 3rd argument 1=FILE_PROCESSOR 2=CONSTRUCTOR 3=AllStates
Assumption:
1.When signal is green another signal green is called the old one is turned red and new one turned green
Design of input format:
1.Names (North,East,South,West,Green,Red) should have first letter capital.
2.First argument in line is the direcion which needs to turn Red,Green or Add cars.
3.Second argument should be either turn signal red,green or comma seperated cars.
