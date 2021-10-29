import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import main.astreader;

public class myrpal {

	public static void main(String[] args) {
		
		//System.out.println("Donowl");
		
		try{
			astreader.read(args[0]);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		// try {
			// File astFile = new File(args[0]);
			// Scanner astReader = new Scanner(astFile);
			
			// while(astReader.hasNextLine()){
				// String data = astReader.nextLine();
				// System.out.println(data);
			// }
			// astReader.close();
		// } catch (FileNotFoundException e) {
			// System.out.println("Error");
			// e.printStackTrace();
		// }
	}
}