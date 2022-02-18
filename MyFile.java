///////////////////////////////////////////////////////////////////////////////////////////////////
//	Name:			Mark Barros
//	Course:			CS1400 - Intro to Programming and Problems Solving
//	Description:	This program reads data from a file that contains integer numbers.
//					It outputs the numbers 10 per line, the total, and the average to a file.
///////////////////////////////////////////////////////////////////////////////////////////////////

// These are necessary inputs. --------------------------------------------------------------------
import java.io.*;
import java.util.Scanner;

// This is the MyFile class. ----------------------------------------------------------------------
public class MyFile
{
	public static void main(String[ ] args) throws IOException
	{
		double currentNumber = 0.0,
		       numberTotal = 0.0,
		       numberAverage = 0.0;
		int    numberCount = 0,
		       currentColumn = 0;

		// File inputFile = new File("/user/tvnguyen7/data/myfile.dat")
		// The pathname will need to be modified accordingly:
		// File inputFile = new File("myfile.dat");
		File inputFile = new File("F:/IdeaProjects/My File/out/production/My File/myfile.dat");
		Scanner readFile = new Scanner(inputFile);

		if(!inputFile.exists()) {
			System.out.println("The file cannot be found.\n");
			System.exit(0);
		}

		PrintWriter outputFile = new PrintWriter("myfile.txt");
		outputFile.print("My Data by Mark Barros\n\n");

		while(readFile.hasNext()) {
			currentNumber = readFile.nextInt();
			outputFile.printf("%3d ", (int)currentNumber);
			currentColumn++;
			if(currentColumn == 10) {
				outputFile.print("\n");
				currentColumn = 0;
			}
			numberTotal =  numberTotal + currentNumber;
			numberCount++;
		}

		numberAverage = numberTotal / numberCount;
		outputFile.print("\n\nCount:   " + numberCount + "\n");
		outputFile.print("Total:   " + (int)numberTotal + "\n");
		outputFile.printf("Average: %011.2f\n", numberAverage);

		readFile.close();
		outputFile.close();
		System.out.println("-------------------------------------------------------------" +
						   "--------------------------------------------");
		System.out.println("The output file 'myfile.txt' was successfully created and " +
				"is located in the root folder of this project.");
		System.out.println("-------------------------------------------------------------" +
				"--------------------------------------------");
	}
} // End of MyFile class. -------------------------------------------------------------------------




