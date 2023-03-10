# cs542-fall-22-assign2
## Name: Tejal Rahul Daga
Slack Days Available: 3

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentRecordsBackupTree/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=<input_file.txt> -Darg1=<delete_file.txt> -Darg2=<output1_file.txt> -Darg3=<output2_file.txt> -Darg4=<output3_file.txt>

## Replace <fileName.txt> with real file names. For example, if the files are available in the path,
## you can run it in the following manner:

ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=input_file.txt -Darg1=delete_file.txt -Darg2=output1_file.txt -Darg3=output2_file.txt -Darg4=output3_file.txt

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:

The design pattern used here is the Observer Pattern. The Observer Pattern defines a one-to-many dependency between objects so that when
one object changes state, all of its dependents are notified and updated automatically. [2]

Recursion is used to insert nodes in the Binary Search Tree. Compare the inserting element with root, if less than root, then recursively call left subtree, else recursively call right subtree.[1] 

Interfaces added: 
Observer - This interfact performs the update on the observer.

Classes added:
BSTBuilder - This is a builder class for the Binary search tree.



References:
[1] www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
[2] Head First Design Patterns by Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 10/23/2022 


