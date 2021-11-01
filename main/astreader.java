package main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList;

import main.nodes.*;
import main.csemachine.*;

//Takes a AST and returns a logic tree of nodes


public class astreader {
	

	public static Node read(String filename) {
		/*
		Takes the input file, 
		Creates the logical AST and returns the root Node
		*/

		Node root = null;

		try {

			File astFile = new File(filename);
			Scanner astReader = new Scanner(astFile);
			
			Node currentNode = null;
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
			//return root;


			//System.out.println("----------");
			// Node newn = root.standardizedVersion();
			// newn.updateDepth();
			// //newn.describe();

			// System.out.println("----------");

			// // ControlStructureGroup csg = new ControlStructureGroup();
			// // csg.createControlStructure(newn);
			// // csg.display();


			// Machine m = new Machine(newn);
			// m.evaluate();
			
			
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}

		return root;
	}

	private static int getDepth(String line) {
		for (int i=0; i<line.length(); i++) {
			if (line.charAt(i)!='.'){ return i; }
		}
		return -1;
	}
}