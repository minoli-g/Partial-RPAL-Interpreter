package main.nodes;

import java.util.ArrayList;

public abstract class Node {
	//private String type;
	protected int depth;
	protected Node parent;
	protected ArrayList<Node> children;
	
	//public Node(String type, int depth) { this.type=type; this.depth = depth; children = new ArrayList<Node>();}
	
	public Node(int depth) { this.depth = depth; children = new ArrayList<Node>();}
	public Node() { children = new ArrayList<Node>(); }
	
	public Node getParent() { return parent; }

	public void setParent(Node n) { 
		this.parent = n; 
		this.depth = getParent().getNodeDepth() + 1;
	}

	public String getType() { return this.getClass().toString(); }
	
	public int getNodeDepth() { return depth; }

	public Node getChildAt(int position) {
		try {
			return children.get(position);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AcceptedNode("NO");
	}

	public int numberOfChildren() { return children.size(); }
	
	public void addChild(Node child) { 
		child.setParent(this); 
		children.add(child); 
	}

	public ArrayList<String> traverse(ArrayList<String> al) {

		al.add(this.getType());
		for (Node n: children){
			n.traverse(al);
		}
		return al;
	}
	
	public void describe() {
	
		//if (parent!=null) { System.out.println(this.getType() + " Child of " + getParent().getType() + Integer.toString(depth)); }
		
		
		StringBuilder sb = new StringBuilder("");
		for (int i=0; i<this.depth; i++) { sb.append(".");}
		sb.append(this.getType());
		System.out.println(sb);
		for (Node n: children) {
			n.describe();
		}
		
		
	}

	public void updateDepth() {
		for (Node n: children) {
			n.setParent(this);
			n.updateDepth();
		}
	}
	
	public Node standardizedVersion(){
		
		Node replacement = getReplacement();
		attachStandardizedChildren(replacement);
		return replacement; 
		
	}
	
	protected abstract Node getReplacement();
	
	// The manner in which to attach the standardized replacements of child nodes to the parent's replacement 
	// standardizedVersion() is called on each child node in this method.
	protected abstract void attachStandardizedChildren(Node replacement);
	
	
}