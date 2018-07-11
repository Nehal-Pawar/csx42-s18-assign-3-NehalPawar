Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code

ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt 
-Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=3
(5th argument 1=FILE_PROCESSOR 2=CONSTRUCTOR 3=AllStates)

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf NehalRajendra_Pawar_assign_3.tar.gz NehalRajendra_Pawar_assign_3

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 7/10/2018]

-----------------------------------------------------------------------

Describe how the observer pattern has been implemented:
The original node acts a subject and the backup 1 and 2 act as listner. 
The Node call implements both subject and listner. The notifyAll method 
updates both the backup listners whose reference is stored in original
node.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
https://stackoverflow.com/questions/29735465/printing-binary-search-tree-inorder-recursively

