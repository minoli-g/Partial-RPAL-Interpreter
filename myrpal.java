import main.nodes.*;
import main.csemachine.*;
import main.csemachine.elements.*;
import main.astreader;


import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class myrpal {

	public static void main(String[] args) {
		
		try{

			Node rootOfAST = astreader.read(args[0]);
			Node standardizedRoot = rootOfAST.standardizedVersion();
			standardizedRoot.updateDepth();

			Machine cseMachine = new Machine(standardizedRoot);
			
			System.out.println("The output of the above program is: ");
			cseMachine.evaluate();

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}