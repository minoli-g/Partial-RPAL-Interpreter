package main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList;

import main.nodes.*;
import main.csemachine.*;

//Takes a AST and returns a logic tree of nodes


public class astreader {
	
	private static int getDepth(String line) {
		for (int i=0; i<line.length(); i++) {
			if (line.charAt(i)!='.'){ return i; }
		}
		return -1;
	}
	
	public static void read(String filename) {
		try {
			File astFile = new File(filename);
			Scanner astReader = new Scanner(astFile);
			
			Node currentNode = null;
			Node root = null;
			int currentDepth = -1;
			
			while(astReader.hasNextLine()){
				
				String line = astReader.nextLine();
				
				int depth = getDepth(line);
				line = line.substring(depth);
				
				//Node thisNode = new Node(line, depth);  //have to add a NodeFactory here
				Node thisNode = NodeFactory.createNode(line, depth);
				
				//executes only if we need to go back up tree
				while (depth < currentDepth) {
					currentNode = currentNode.getParent();
					currentDepth = currentNode.getNodeDepth();
				}
				
				if (depth==currentDepth+1) { 
				
					if (currentDepth != -1) { currentNode.addChild(thisNode); }
					else { root = thisNode; }
					currentDepth++; 
					currentNode = thisNode; 
				}
				
				else if (depth==currentDepth) { currentNode.getParent().addChild(thisNode); currentNode = thisNode; }
				
				else { System.out.println("Error"); }
				
				//System.out.println(line);
			}
			
			astReader.close();
			System.out.println("----------");
			Node newn = root.standardizedVersion();
			newn.updateDepth();
			newn.describe();

			System.out.println("----------");
			//machine.traverse(newn);

			ControlStructureGroup csg = new ControlStructureGroup();
			csg.createControlStructure(newn);
			csg.display();
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}