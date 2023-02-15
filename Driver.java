package studentRecordsBackupTree.driver;

import studentRecordsBackupTree.bst.BST;
import studentRecordsBackupTree.bst.BSTBuilder;
import studentRecordsBackupTree.util.MyLogger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author placeholder
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	    if (args.length != 5) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 5 arguments.");
			System.exit(0);
		}

		try {
			// parsing arguments
			String inputFile = args[0];
			String outputFile = args[1];
			String errorFile = args[2];
			int debugLevel = Integer.parseInt(args[3]);
			int updateValue = Integer.parseInt(args[4]);

			// setting logger level
			MyLogger.setDebugValue(debugLevel);

			Scanner scanner = new Scanner(new File(inputFile));
			// readling line by line
			while(scanner.hasNextLine()) {
				// creating bst builders
				BSTBuilder backup1BSTBuilder = new BSTBuilder();
				BSTBuilder backup2BSTBuilder = new BSTBuilder();

				// setting builders as backups
				BSTBuilder mainBSTBuilder = new BSTBuilder(Arrays.asList(backup1BSTBuilder, backup2BSTBuilder));

				// readling line by line and adding integer values to main BST. Backups will be also updated
				while(scanner.hasNextLine()) {
					int number = Integer.parseInt(scanner.nextLine());
					mainBSTBuilder.add(number, "");
				}

				// building trees
				BST mainBST = mainBSTBuilder.build();
				BST backup1BST = backup1BSTBuilder.build();
				BST backup2BST = backup2BSTBuilder.build();

				// printing trees' content
				MyLogger.writeMessage("Main BST: ", MyLogger.DebugLevel.NONE);
				mainBST.printInorder();
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);

				MyLogger.writeMessage("Backup 1 BST: ", MyLogger.DebugLevel.NONE);
				backup1BST.printInorder();
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);

				MyLogger.writeMessage("Backup 2 BST: ", MyLogger.DebugLevel.NONE);
				backup2BST.printInorder();
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);

				// calculating tree element sum
				MyLogger.writeMessage("Main BST sum: " + mainBST.sum(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage("Backup 1 BST sum: " + backup1BST.sum(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage("Backup 2 BST sum: " + backup2BST.sum(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);

				// incrementing main bst values
				mainBST.increment(updateValue);

				// printing trees' content
				MyLogger.writeMessage("Main BST: ", MyLogger.DebugLevel.NONE);
				mainBST.printInorder();
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);

				MyLogger.writeMessage("Backup 1 BST: ", MyLogger.DebugLevel.NONE);
				backup1BST.printInorder();
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);

				MyLogger.writeMessage("Backup 2 BST: ", MyLogger.DebugLevel.NONE);
				backup2BST.printInorder();
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);

				// calculating tree element sum
				MyLogger.writeMessage("Main BST sum: " + mainBST.sum(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage("Backup 1 BST sum: " + backup1BST.sum(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage("Backup 2 BST sum: " + backup2BST.sum(), MyLogger.DebugLevel.NONE);
				MyLogger.writeMessage(System.lineSeparator(), MyLogger.DebugLevel.NONE);
			}
		}
		catch (NumberFormatException e) {
			MyLogger.writeMessage("Can not integer", MyLogger.DebugLevel.FILE_PROCESSOR);
		}
		catch (IOException e) {
			MyLogger.writeMessage("Can not open input file", MyLogger.DebugLevel.FILE_PROCESSOR);

		}
	}
}
